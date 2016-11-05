package lukeklepfer.com.herome.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import lukeklepfer.com.herome.R;
import lukeklepfer.com.herome.activities.MainActivity;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PowersFragment.PickPowersInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PowersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PowersFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button turtleBtn;
    private Button lightningBtn;
    private Button flightBtn;
    private Button webBtn;
    private Button laserBtn;
    private Button superBtn;
    private Button showBtn;


    private PickPowersInteractionListener mListener;

    public PowersFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PowersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PowersFragment newInstance(String param1, String param2) {
        PowersFragment fragment = new PowersFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_powers, container, false);

        turtleBtn = (Button)view.findViewById(R.id.turtleBtn);
        lightningBtn = (Button)view.findViewById(R.id.lightningBtn);
        flightBtn = (Button)view.findViewById(R.id.flightBtn);
        webBtn = (Button)view.findViewById(R.id.webBtn);
        laserBtn = (Button)view.findViewById(R.id.laserBtn);
        superBtn = (Button)view.findViewById(R.id.superBtn);
        showBtn = (Button)view.findViewById(R.id.showBtn);

        showBtn.getBackground().setAlpha(128);
        showBtn.setEnabled(false);

        turtleBtn.setOnClickListener(this);
        lightningBtn.setOnClickListener(this);
        flightBtn.setOnClickListener(this);
        webBtn.setOnClickListener(this);
        laserBtn.setOnClickListener(this);
        superBtn.setOnClickListener(this);
        showBtn.setOnClickListener(this);

        showBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity)getActivity();//finds host activity
                mainActivity.loadBackstoryScreen();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onClick(View view) {

        showBtn.getBackground().setAlpha(255);
        showBtn.setEnabled(true);

        turtleBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.turtle_power, 0, 0, 0);
        lightningBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.lightning, 0, 0, 0);
        flightBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.superman_crest, 0, 0, 0);
        webBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.spider_web, 0, 0, 0);
        laserBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.laser_vision, 0, 0, 0);
        superBtn.setCompoundDrawablesWithIntrinsicBounds(R.drawable.super_strength, 0, 0, 0);

        Button btn = (Button) view;
        int leftDrawable = 0;

        if (btn == turtleBtn) {
            leftDrawable = R.drawable.turtle_power;
        } else if (btn == lightningBtn) {
            leftDrawable = R.drawable.lightning;
        } else if (btn == flightBtn) {
            leftDrawable = R.drawable.superman_crest;
        } else if (btn == webBtn) {
            leftDrawable = R.drawable.spider_web;
        } else if (btn == laserBtn) {
            leftDrawable = R.drawable.laser_vision;
        } else if (btn == superBtn) {
            leftDrawable = R.drawable.super_strength;
        }
        btn.setCompoundDrawablesWithIntrinsicBounds(leftDrawable, 0, R.drawable.item_selected, 0);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onPickPowersInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PickPowersInteractionListener) {
            mListener = (PickPowersInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement PickPowersInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface PickPowersInteractionListener {
        // TODO: Update argument type and name
        void onPickPowersInteraction(Uri uri);
    }
}
