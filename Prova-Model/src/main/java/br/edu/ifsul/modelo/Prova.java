/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

/**
 *
 * @author Meu computador
 */
@Entity
@Table(name = "prova")
@Inheritance(strategy = InheritanceType.JOINED)
public class Prova implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_prova", sequenceName = "seq_prova_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_prova", strategy = GenerationType.SEQUENCE)    
    private Integer id;
    
    @Length(max = 50, message = "O descricao não pode ter mais que {max} caracteres")
    @Column(name = "descricao", nullable = false, length = 50)    
    private String descricao;
    @NotNull(message = "Volume é obrigatório")
    @Range(min=0,max=10,message="A nota ´so pode variar de 0 a 10")
    @Column(name = "mediaGeral")       
    private Double mediaGeral;
   
    @NotBlank(message = "O conteudo não pode ser em branco")
    @Length(max = 50, message = "O conteudo não pode ter mais que {max} caracteres")
    @Column(name = "conteudo", nullable = false, length = 50)    
    private String conteudo;
    @NotNull(message = "A dataProva deve ser informada")
    @Column(name = "dataProva", nullable = false)
    private Calendar dataProva;
    @NotBlank(message = "O professor não pode ser em branco")
    @Length(max = 50, message = "O professor não pode ter mais que {max} caracteres")
    @Column(name = "professor", nullable = false, length = 50)    
    private String professor;
   
    @OneToMany(mappedBy = "prova", cascade = CascadeType.ALL, 
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Nota> notas = new ArrayList<>();

    public Prova() {
    }

    public void adicionarNota(Nota obj){
        obj.setProva(this);
        this.notas.add(obj);

    }
    
    public void removerNota(int index){
        this.notas.remove(index);
 
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getMediaGeral() {
        return mediaGeral;
    }

    public void setMediaGeral(Double mediaGeral) {
        this.mediaGeral = mediaGeral;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Calendar getDataProva() {
        return dataProva;
    }

    public void setDataProva(Calendar dataProva) {
        this.dataProva = dataProva;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
        
    }

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prova other = (Prova) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}

    