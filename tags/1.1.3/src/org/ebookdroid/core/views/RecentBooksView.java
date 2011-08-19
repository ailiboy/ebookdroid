package org.ebookdroid.core.views;

import org.ebookdroid.core.IBrowserActivity;
import org.ebookdroid.core.presentation.RecentAdapter;
import org.ebookdroid.core.settings.BookSettings;

import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;

import java.io.File;

public class RecentBooksView extends android.widget.ListView implements AdapterView.OnItemClickListener {

    protected final IBrowserActivity base;

    protected final RecentAdapter adapter;

    public RecentBooksView(final IBrowserActivity base, final RecentAdapter adapter) {
        super(base.getContext());

        this.base = base;
        this.adapter = adapter;

        setAdapter(adapter);
        setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_LOW);
        setOnItemClickListener(this);
        setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
                ViewGroup.LayoutParams.FILL_PARENT));
    }

    @Override
    public void onItemClick(final AdapterView<?> adapterView, final View view, final int i, final long l) {
        final BookSettings bs = adapter.getItem(i);
        base.showDocument(Uri.fromFile(new File(bs.getFileName())));
    }
}
