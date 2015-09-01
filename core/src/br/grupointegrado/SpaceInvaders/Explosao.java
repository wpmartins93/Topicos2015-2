package br.grupointegrado.SpaceInvaders;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Wellington on 31/08/2015.
 */
public class Explosao {

    private static float tempoTroca = 1f / 17f; // aproximadamente 0,05 segundos por imagem

    private int estagio = 0; // controla o estagio de 0 a 16
    private Array<Texture> texturas;
    private Image ator;
    private float tempoAcumulado = 0;

    public Explosao(Image ator, Array<Texture> texturas){
        this.ator = ator;
        this.texturas = texturas;
    }


    public int getEstagio(){
        return estagio;
    }

    public Image getAtor(){
        return ator;
    }

    /**
     * Calcula o tempo acumulado e realiza a troca do estágio da explosão.
     * Exemplo:
     * cada quadro demora 0,016 segundos
     * cada imagem deve permanecer 0,05 segundos
     * @param delta
     */
    public void atualizar(float delta){
        tempoAcumulado = tempoAcumulado + delta;
        if (tempoAcumulado >= tempoTroca){
            tempoAcumulado = 0;
            estagio ++;
            Texture textura = texturas.get(estagio);
            ator.setDrawable(new SpriteDrawable(new Sprite(textura)));
        }
    }
}
