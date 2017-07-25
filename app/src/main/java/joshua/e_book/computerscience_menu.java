package joshua.e_book;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class computerscience_menu extends FragmentActivity {
//    Button btnCSS, btnHTML;
  //  LinearLayout container;
    TextView textView;
ArrayList moduleList;
    private RecyclerView recyclerView;
    private ComputerScienceModulesAdapter adapter;
    private LinearLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computerscience_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        container = (LinearLayout)findViewById(R.id.fragment_layout);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_modules);
        moduleList = new ArrayList<>();
        adapter = new ComputerScienceModulesAdapter(this, moduleList);
        textView = (TextView)findViewById(R.id.moduleTextView);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
     //   recyclerView.setAdapter(adapter);

        prepareModules();
        // ProductListAdapter adapter = new ProductListAdapter(this, productNames, productImages);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_modules);
        recyclerView.setAdapter(adapter);
    }
        private void prepareModules() {
            int[] moduleImages = { R.drawable.pdf_icon};

            ComputerScienceModules a = new ComputerScienceModules("Learn CSS", moduleImages[4]);
            moduleList.add(a);

            a = new ComputerScienceModules("Learn HTML", moduleImages[4]);
            moduleList.add(a);

            a = new ComputerScienceModules("Learn Javascript", moduleImages[4]);
            moduleList.add(a);

            a = new ComputerScienceModules("Learn PHP", moduleImages[4]);
            moduleList.add(a);

            adapter.notifyDataSetChanged();
            adapter.setOnItemClickListener(new ComputerScienceModulesAdapter.ClickListener() {
                @Override
                public void onItemClick(int position, View v) {
                    if (position == 0) {
                        startActivity(new Intent(computerscience_menu.this, Modules_CSS.class));
                    }

                    else if (position == 1) {
                        startActivity(new Intent(computerscience_menu.this, module_html.class));
                    }

                    else if (position == 2) {
                        startActivity(new Intent(computerscience_menu.this, module_javascript.class));
                    }

                    else if (position == 3) {

                        startActivity(new Intent(computerscience_menu.this, module_php.class));
                    } else {
                        Toast.makeText(computerscience_menu.this, "Out of bounds", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onItemLongClick(int position, View v) {
                    // Log.d(TAG, "onItemLongClick pos = " + position);
                }
            });
        }
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }
                private int dpToPx(int dp) {
                    Resources r = getResources();
                    return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
                }


}
