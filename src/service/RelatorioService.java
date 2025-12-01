package service;

import model.Animal;
import model.Consulta;
import model.Tutor;

import java.util.*;
import java.util.stream.Collectors;

public class RelatorioService {

    private List<Consulta> consultas;

    public RelatorioService(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    // Tipo de animal mais frequente
    public void tipoAnimalMaisFrequente() {
        Map<String, Long> contagem = consultas.stream()
                .map(c -> c.getAnimal().getTipo().name())
                .collect(Collectors.groupingBy(tipo -> tipo, Collectors.counting()));

        contagem.forEach((tipo, qtd) -> System.out.println("Tipo: " + tipo + " - " + qtd + " vezes"));

        contagem.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(entry -> System.out.println("Animal mais frequente: " + entry.getKey() + " (" + entry.getValue() + " vezes)"));
    }

    // Doença mais frequente
    public void doencaMaisFrequente() {
        Map<String, Long> contagem = consultas.stream()
                .map(c -> c.getAnimal().getDoenca())
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(d -> d, Collectors.counting()));

        contagem.forEach((doenca, qtd) -> System.out.println("Doença: " + doenca + " - " + qtd + " vezes"));

        contagem.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(entry -> System.out.println("Doença mais frequente: " + entry.getKey() + " (" + entry.getValue() + " vezes)"));
    }

    // Alertar tutor se pet aparece mais de duas vezes com a mesma doença
    public void alertarTutor() {
        Map<Tutor, Map<String, Long>> tutorDoenca = new HashMap<>();

        for (Consulta c : consultas) {
            Animal a = c.getAnimal();
            Tutor t = a.getTutor();
            String doenca = a.getDoenca();

            if (t != null && doenca != null) {
                tutorDoenca.putIfAbsent(t, new HashMap<>());
                Map<String, Long> doencas = tutorDoenca.get(t);
                doencas.put(doenca, doencas.getOrDefault(doenca, 0L) + 1);
            }
        }

        tutorDoenca.forEach((tutor, doencas) -> {
            doencas.forEach((doenca, qtd) -> {
                if (qtd > 2) {
                    System.out.println("Alerta: O tutor " + tutor.getNome() + " tem um pet com " + doenca + " mais de 2 vezes.");
                }
            });
        });
    }

    // Aplicar desconto automático em consultas não pagas se tutor levou pet mais de 3 vezes
    public void aplicarDescontoAutomatico(double percentualDesconto) {
        Map<Tutor, Long> consultasPorTutor = consultas.stream()
                .map(c -> c.getAnimal().getTutor())
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(t -> t, Collectors.counting()));

        consultasPorTutor.forEach((tutor, qtd) -> {
            if (qtd > 3) {
                System.out.println("O tutor " + tutor.getNome() + " tem direito a desconto de " + percentualDesconto + "% nas próximas consultas!");
                consultas.stream()
                        .filter(c -> c.getAnimal().getTutor() == tutor && !c.isPaga())
                        .forEach(c -> {
                            double valorOriginal = c.getValor();
                            c.getClass(); // só para referência, mantém lógica atual
                            double valorDescontado = valorOriginal * (1 - percentualDesconto / 100);
                            // Reflete desconto sem alterar demais
                            try {
                                java.lang.reflect.Field field = c.getClass().getDeclaredField("valor");
                                field.setAccessible(true);
                                field.setDouble(c, valorDescontado);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        });
            }
        });
    }
}

