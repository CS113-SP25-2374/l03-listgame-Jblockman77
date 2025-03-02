package cs113.listGame.enemies;

import cs113.listGame.behaviors.Behavior;
import cs113.listGame.behaviors.MoveToPoint;
import cs113.listGame.behaviors.Waiting;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;

import java.util.LinkedList;
import java.util.Random;

public class EnemyLinkedList extends EnemyObject {
    Random random = new Random();
    LinkedList<Behavior> behaviors = new LinkedList<>();
    public EnemyLinkedList(ImageView imageView) { super(imageView); }

    @Override
    public void seedBehaviors() {
        Point2D dest = new Point2D(random.nextDouble(500), random.nextDouble(400));

        behaviors.add(new Waiting(this, 1000));
        behaviors.add(new MoveToPoint(this, 500, dest));
    }

    @Override
    public Behavior getNextBehavior() {

        if(behaviors.isEmpty()){
            return null;
        }

        int index = random.nextInt(behaviors.size());
        Behavior behavior = behaviors.get(index);
        behaviors.set(index, null);
        return behavior;
    }
}
