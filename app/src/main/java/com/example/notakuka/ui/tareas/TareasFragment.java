package com.example.notakuka.ui.tareas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
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
import com.example.notakuka.databinding.FragmentTareasBinding;

public class TareasFragment extends Fragment {

    private com.example.notakuka.ui.tareas.tareashowViewModel tareashowViewModel;
    private FragmentTareasBinding binding;

    Button Btn_Agregartare;
    TextView TituloTarea,ContenidoTarea;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        tareashowViewModel =
                new ViewModelProvider(this).get(com.example.notakuka.ui.tareas.tareashowViewModel.class);

        binding = FragmentTareasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textTareas;
        tareashowViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });






        TituloTarea=(EditText) root.findViewById(R.id.TxtTituloTarea);

        ContenidoTarea=(EditText) root.findViewById(R.id.TxtContenidoTarea);
        Btn_Agregartare=(Button) root.findViewById(R.id.BtnAgregarTarea);

        Btn_Agregartare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            String titulotarea=TituloTarea.getText().toString();
            String contenidTarea=ContenidoTarea.getText().toString();
                AppDataBaseTareas appDataBaseTareas= AppDataBaseTareas.getAppDataBaseTareasInstance(getActivity());
                TareaDao tareaDao= appDataBaseTareas.getTareaDao();
                AppDataBaseTareas.databaseWriteExecutorTareas.execute(() -> {
                    Tareas u=new Tareas();
                    u.tituloTarea=titulotarea;
                    u.contenidoTarea=contenidTarea;
                    tareaDao.insertAll(u);
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