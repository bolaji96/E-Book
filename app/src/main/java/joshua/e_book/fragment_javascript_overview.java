package joshua.e_book;

import android.app.Activity;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.pdf.PdfRenderer;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * create an instance of this fragment.
 */
public class fragment_javascript_overview extends Fragment implements View.OnClickListener{

    private static final String STATE_CURRENT_PAGE_INDEX = "current_page_index";
    private ParcelFileDescriptor fileDescriptor;
    public PdfRenderer pdfRenderer;
    public String filename = "javascript_overview.pdf";
    private PdfRenderer.Page currentPage;
    private ImageView image;
    private Button btnPrevious;
    private Button btnNext;


    public fragment_javascript_overview() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment__cs, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Retain view references.
        image = (ImageView) view.findViewById(R.id.image);
        btnPrevious = (Button) view.findViewById(R.id.btn_previous);
        btnNext = (Button) view.findViewById(R.id.btn_next);

        //set buttons event
        btnPrevious.setOnClickListener(onActionListener(-1)); //previous button clicked
        btnNext.setOnClickListener(onActionListener(1)); //next button clicked
        int index = 0;
        // If there is a savedInstanceState (screen orientations, etc.), we restore the page index.
        if (null != savedInstanceState) {
            index = savedInstanceState.getInt(STATE_CURRENT_PAGE_INDEX, 0);
        }
        CopyAssetsbrochure(filename);
        showPage(index);
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        //openedPdfFileName = "css_overview.pdf" ;
        try {
            openRenderer();
        } catch (IOException e) {
            e.printStackTrace();
            activity.finish();
        }
    }

    @Override
    public void onDetach() {
        closeRenderer();
        super.onDetach();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (null != currentPage) {
            outState.putInt(STATE_CURRENT_PAGE_INDEX, currentPage.getIndex());
        }
    }

    private void openRenderer() throws IOException {
        File fileBrochure = new File("/sdcard/" + "/" + filename);
        if (!fileBrochure.exists())
        {
            CopyAssetsbrochure(filename);
            File file = new File("/sdcard/" + "/" + filename);
            try {
                fileDescriptor = ParcelFileDescriptor.open(file,
                        ParcelFileDescriptor.MODE_READ_ONLY);
                pdfRenderer = new PdfRenderer(fileDescriptor);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (fileBrochure.exists())
        {
            try {
                fileDescriptor = ParcelFileDescriptor.open(fileBrochure,
                        ParcelFileDescriptor.MODE_READ_ONLY);
                pdfRenderer = new PdfRenderer(fileDescriptor);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void CopyAssetsbrochure(String filename) {
        AssetManager assetManager = getActivity().getAssets();
        //String[] files = null;
        this.filename = filename;
        InputStream in = null;
        OutputStream out = null;
        File file = new File(getActivity().getFilesDir(), filename);
        try {
            in = assetManager.open(filename);
            out = new FileOutputStream("/sdcard/" + "/" + filename);
            copyFile(in, out);
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;
            //break;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1) {
            out.write(buffer, 0, read);
        }
    }


    /**
     * Closes PdfRenderer and related resources.
     */
    private void closeRenderer() {

        try {
            if (currentPage != null)
                currentPage.close();
            if (pdfRenderer != null)
                pdfRenderer.close();
            if (fileDescriptor != null)
                fileDescriptor.close();
        } catch (Exception e) {
            //TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Shows the specified page of PDF file to screen
     * @param index The page index.
     */

    private void showPage(int index) {
        if (pdfRenderer == null || pdfRenderer.getPageCount() <= index
                || index < 0) {
            return;
        }
        // For closing the current page before opening another one.
        try {
            if (currentPage != null) {
                currentPage.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Open page with specified index
        currentPage = pdfRenderer.openPage(index);
        Bitmap bitmap = Bitmap.createBitmap(getResources().getDisplayMetrics().densityDpi / 72 * currentPage.getWidth(),
                getResources().getDisplayMetrics().densityDpi / 72 * currentPage.getHeight(),Bitmap.Config.ARGB_8888);

        //Pdf page is rendered on Bitmap
        currentPage.render(bitmap, null, null,
                PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);
        //Set rendered bitmap to ImageView
        image.setImageBitmap(bitmap);
        //updateActionBarText();

        updateUIData();
    }
    /**
     * Updates the state of 2 control buttons in response to the current page index.
     */
    private void updateUIData() {
        int index = currentPage.getIndex();
        //int pageCount = pdfRenderer.getPageCount();
        btnPrevious.setEnabled(0 != index);
        btnNext.setEnabled(index + 1 < pdfRenderer.getPageCount());
        getActivity().setTitle(getString(R.string.Javascript_Overview, index + 1, pdfRenderer.getPageCount()));
    }


    private View.OnClickListener onActionListener(final int i) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (i < 0) {//go to previous page
                    showPage(currentPage.getIndex() - 1);
                } else {
                    showPage(currentPage.getIndex() + 1);
                }
            }
        };
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_previous: {
                //go to previous page
                showPage(currentPage.getIndex() - 1);
                break;
            }
            case R.id.btn_next: {
                //go to the next page
                showPage(currentPage.getIndex() + 1);
            }
        }
    }



}
