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
public class MaterialDigital extends Exemplar
{
    private int anoPublicacao;
    private TipoMaterial tipoMaterial;
    
    public MaterialDigital()
    {
        super();
        setAnoPublicacao(0);
        setTipoMaterial(TipoMaterial.AUDIO);
    }

    public MaterialDigital(int anoPublicacao,TipoMaterial tipo)
    {
        super();
        setAnoPublicacao(anoPublicacao);
        setTipoMaterial(tipo);
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public TipoMaterial getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(TipoMaterial tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }
}
