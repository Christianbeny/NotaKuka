package com.example.notakuka.ui.notas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.notakuka.DAOS.NotaDao;
import com.example.notakuka.DBA.AppDataBaseNotas;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.notakuka.DBA.AppDataBaseNotas;
import com.example.notakuka.MODELOS.Notas;
import com.example.notakuka.R;
import com.example.notakuka.databinding.FragmentNotasBinding;

public class NotasFragment extends Fragment {

    private com.example.notakuka.ui.notas.notasViewModel notasViewModel;
    private FragmentNotasBinding binding;


Button Btn_Agregar;


    TextView Titulo,Contenido;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {




        notasViewModel =
                new ViewModelProvider(this).get(com.example.notakuka.ui.notas.notasViewModel.class);

        binding = FragmentNotasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textNotas;
        notasViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });




Titulo=(EditText) root.findViewById(R.id.TxtTitulo);

        Contenido=(EditText) root.findViewById(R.id.TxtContenido);
Btn_Agregar=(Button) root.findViewById(R.id.BtnCrearNota);

Btn_Agregar.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
 String Titu = Titulo.getText().toString();
          String Cont = Contenido.getText().toString();


        AppDataBaseNotas appDataBaseNotas= AppDataBaseNotas.getAppDataBaseNotasInstance(getActivity());
        NotaDao notaDao=appDataBaseNotas.getNotaDao();
        AppDataBaseNotas.databaseWriteExecutorNotas.execute(() -> {
               Notas u=new Notas();
             u.tituloNota=Titu;
             u.contenidoNota=Cont;
               notaDao.insertAll(u);

           });




    }
});
        return root;



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;





    }
}