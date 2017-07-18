/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Beatriz
 */
public enum TipoMaterial {
    AUDIO("Áudio"), VIDEO("Video");
    
    private String descricao;
    
    TipoMaterial(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public static TipoMaterial getTipoPorDescricao(String descricao)
    {
        for (TipoMaterial tipo : TipoMaterial.values())
        {
            if(tipo.getDescricao().equals(descricao)) {
                return tipo;
            }
        }
        return null;
    }
}