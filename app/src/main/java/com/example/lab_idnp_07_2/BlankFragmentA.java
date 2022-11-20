package com.example.lab_idnp_07_2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragmentA#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragmentA extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragmentA() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragmentA.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragmentA newInstance(String param1, String param2) {
        BlankFragmentA fragment = new BlankFragmentA();
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

    Button restaurante1,restaurante2, restaurante3;
    ArrayList<Restaurante> restaurantes;

    public Restaurante buscarPorNombreRes(String name){
        Restaurante aux=null;
        for (Restaurante res:restaurantes) {
            if(res.getNombre().equalsIgnoreCase(name)){
                aux=res;
            }
        }
        return aux;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_blank_a, container, false);
        restaurante1=v.findViewById(R.id.buttonRes1);
        restaurante2=v.findViewById(R.id.buttonRes2);
        restaurante3=v.findViewById(R.id.buttonRes3);

        restaurantes=new ArrayList<Restaurante>();
        restaurantes.add(new Restaurante("Benito",100,"Calle Mercaderes 202"));
        restaurantes.add(new Restaurante("Maria's",200,"Avenida las Americas 777"));
        restaurantes.add(new Restaurante("Pulpo",150,"Calle 27 de julio 102"));

        Bundle bundle= new Bundle();

        restaurante1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("restaurante",buscarPorNombreRes("Benito").mostrar());
                getParentFragmentManager().setFragmentResult("dataFrom1", bundle);
            }
        });

        restaurante2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("restaurante",buscarPorNombreRes("Maria's").mostrar());
                getParentFragmentManager().setFragmentResult("dataFrom1", bundle);
            }
        });

        restaurante3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putString("restaurante",buscarPorNombreRes("Pulpo").mostrar());
                getParentFragmentManager().setFragmentResult("dataFrom1", bundle);
            }
        });
        return v;
    }
}