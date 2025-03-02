package cs113.listGame.resources;

import cs113.listGame.gamecore.GameObject;

import java.util.LinkedList;
import java.util.List;

public class ResourceLinkedList implements ResourceList {

    LinkedList<ResourceObject> resources = new LinkedList<>();

    @Override
    public void add(ResourceObject resource) {
        resources.add(resource);
    }

    @Override
    public void remove(ResourceObject resource) {
        resources.remove(resource);
    }

    @Override
    public void truncate(ResourceObject resource) {
        int count = resources.indexOf(resource);
        for (int i = 0; i < resources.size() - count; i++) {
            resources.remove(count);
        }
    }

    @Override
    public void follow(GameObject leader) {
        for (int i = 0; i < resources.size(); i++) {
            if (resources.get(i) != null) {
                resources.get(i).moveTowards(leader.getEchoCenter());
                leader = resources.get(i);
            }
        }
    }
}
