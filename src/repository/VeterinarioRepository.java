package repository;

import model.Veterinario;
import java.util.ArrayList;
import java.util.List;

public class VeterinarioRepository {
    private List<Veterinario> veterinarios = new ArrayList<>();

    public void salvar(Veterinario v) {
        veterinarios.add(v);
    }

    public List<Veterinario> listar() {
        return veterinarios;
    }

}
