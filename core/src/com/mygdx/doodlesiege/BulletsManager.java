package com.mygdx.doodlesiege;

import com.mygdx.doodlesiege.mobs.Mob;

import java.util.ArrayList;

public class BulletsManager {
    private MobsManager mobsManager;
    private MapManager mapManager;

    public BulletsManager(MobsManager mobsManager, MapManager mapManager){
        this.mobsManager = mobsManager;
        this.mapManager = mapManager;
    }
    public void mainCycle(){
        ArrayList<Bullet> bulletsToRemove = new ArrayList<>();
        ArrayList<Mob> mobsToRemove = new ArrayList<>();
        for(Bullet bullet : Global.player.firedBullets){
            bullet.x += bullet.dx * Global.getDeltaTimeMultiplier();
            bullet.y += bullet.dy * Global.getDeltaTimeMultiplier();
            if(bullet.x >= mapManager.width || bullet.x <=0 || bullet.y >= mapManager.height || bullet.y <= 0){
                bulletsToRemove.add(bullet);
            }
            else {
                for (Mob mob : mobsManager.presentMobs) {
                    if (bullet.collidesWith(mob)) {
                        if (!(mob.id.equals("player"))) {
                            mob.getHit(bullet.damage);
                            if(mob.hp <= 0){
                                mobsToRemove.add(mob);
                            }
                            bulletsToRemove.add(bullet);
                        }
                    }
                }
            }
        }
        for(Bullet bullet : bulletsToRemove) {
            Global.player.firedBullets.remove(bullet);
        }
        for(Mob mob : mobsToRemove){
        Global.player.kills += 1;
            mobsManager.presentMobs.remove(mob);
        }
    }

    public void dispose(){
        Global.player.firedBullets.clear();
    }
}
