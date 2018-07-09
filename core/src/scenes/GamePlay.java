package scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.dona.JackGame;
import helpers.GameInfo;

public class GamePlay implements Screen {

    private JackGame jackGame;
    private Sprite[] bgs;

    //Camara que seguira al Sprite
    private OrthographicCamera mainCamera;
    //Punto de vista de la pantalla que se asignara a la mainCamera
    private Viewport viewPort;

    public GamePlay(JackGame jackGame) {
        this.jackGame = jackGame;
        mainCamera = new OrthographicCamera(GameInfo.WIDTH,GameInfo.HEIGHT);
        mainCamera.position.set(GameInfo.WIDTH / 2f, GameInfo.HEIGHT/2f,0);
        viewPort = new StretchViewport(GameInfo.WIDTH,GameInfo.HEIGHT,mainCamera );
        createBackGrounds();

    }

    private void update(float dt){
        moveCamera();
    }

    private void moveCamera(){
        mainCamera.position.y-=1;
    }

    //Creando y posicionando los fondos uno detras del otro
    private void createBackGrounds(){
        bgs = new Sprite[3];
        for (int i = 0; i<bgs.length;i++){
            bgs[i] = new Sprite(new Texture("Backgrounds/Game BG.png"));
            bgs[i].setPosition(0,-(i* bgs[i].getHeight()));
        }
    }

    //Dibujando los fondos
    private void drawBackgrounds(){
        for (int i =0 ; i<bgs.length;i++){
            jackGame.getBatch().draw(bgs[i],bgs[i].getX(),bgs[i].getY());
        }
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        //Actualizando a la velocidad delta que es lo que toma de un cuadro a otro
        update(delta);
        //Limpiando la pantalla antes de dibujar algo en ella
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        //Comenzando a dibujar cosas en pantalla
        jackGame.getBatch().begin();


        drawBackgrounds();

        //Terminando de dibujar
        jackGame.getBatch().end();

        jackGame.getBatch().setProjectionMatrix(mainCamera.combined);
        mainCamera.update();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
