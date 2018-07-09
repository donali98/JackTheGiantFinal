package clouds;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;
import helpers.GameInfo;

public class Cloud extends Sprite {
    //mundo fisico en donde la nube estara
    private World world;
    private Body body;
    private String cloudName;

    public Cloud(World world, String cloudName){
        super(new Texture("Clouds/"+cloudName+".png"));
        this.world = world;
        this.cloudName = cloudName;
    }

    private void createBody(){
        //Definiendo el cuerpo de la nube
        BodyDef bodyDef  = new BodyDef();
        bodyDef.type = BodyDef.BodyType.StaticBody;

        bodyDef.position.set((getX() - 40 ) /GameInfo.PIXELS_PER_METER,
                (getY())/GameInfo.PIXELS_PER_METER);

        body = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox((getWidth()/2f -20) /GameInfo.PIXELS_PER_METER,
                (getHeight()/2f)/GameInfo.PIXELS_PER_METER );

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;

        Fixture fixture = body.createFixture(fixtureDef);

        shape.dispose();
    }

    public void setSpritePosition( float x, float y){
        setPosition(x,y);
        createBody();
    }

    public String getCloudName() {
        return cloudName;
    }
}
