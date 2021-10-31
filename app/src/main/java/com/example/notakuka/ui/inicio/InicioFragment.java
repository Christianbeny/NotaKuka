package com.example.notakuka.ui.inicio;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.notakuka.DAOS.NotaDao;
import com.example.notakuka.DAOS.TareaDao;
import com.example.notakuka.DBA.AppDataBaseNotas;
import com.example.notakuka.DBA.AppDataBaseTareas;
import com.example.notakuka.MODELOS.Notas;
import com.example.notakuka.MODELOS.Tareas;
import com.example.notakuka.R;
import com.example.notakuka.databinding.FragmentInicioBinding;

public class InicioFragment extends Fragment {

    private InicioViewModel inicioViewModel;
    private FragmentInicioBinding binding;




    Button Btn_consulta, BtnConsultarTareas;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        inicioViewModel =
                new ViewModelProvider(this).get(InicioViewModel.class);

        binding = FragmentInicioBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        inicioViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });





        Btn_consulta=(Button) root.findViewById(R.id.BtnConslutaNotas);

Btn_consulta.setOnClickListener(view -> {



    AppDataBaseNotas appDataBaseNotas= AppDataBaseNotas.getAppDataBaseNotasInstance(getActivity());
    NotaDao notaDao=appDataBaseNotas.getNotaDao();
    AppDataBaseNotas.databaseWriteExecutorNotas.execute(() -> {
       for (Notas item:notaDao.getAll()){
           Log.d("notas",item.tituloNota+" "+item.contenidoNota);
       }

    });
});



        BtnConsultarTareas=(Button) root.findViewById(R.id.BtnconsultaTarea);
        BtnConsultarTareas.setOnClickListener(view -> {




            AppDataBaseTareas appDataBaseTareas= AppDataBaseTareas.getAppDataBaseTareasInstance(getActivity());
            TareaDao tareaDao=appDataBaseTareas.getTareaDao();
        AppDataBaseTareas.databaseWriteExecutorTareas.execute(() -> {
            for (Tareas item:tareaDao.getAll()){
                Log.d("tareas",item.tituloTarea+" "+item.contenidoTarea);
            }
        });
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}