package com.mycompany.cadastroTarefas.Model;

public class Task {
    private String titulo;
    private String descricao;
    private String responsavel;
    private String prioridade;
    private String deadline;

    public Task(String titulo, String descricao, String responsavel, String prioridade, String deadline) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.responsavel = responsavel;
        this.prioridade = prioridade;
        this.deadline = deadline;
    }

    /**
     * Retorna o ID do item.
     *
     * @return id do item.
     */
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Retorna o nome do item.
     *
     * @return nome do item.
     */
    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna a quantidade em estoque.
     *
     * @return quantidade em estoque.
     */
    public String getResponsavel() {
        return responsavel;
    }


    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    /**
     * Retorna o valor do item.
     *
     * @return valor do item.
     */
    public String getPrioridade() {
        return prioridade;
    }


    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public String getDeadline() {
        return deadline;
    }


    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
}

