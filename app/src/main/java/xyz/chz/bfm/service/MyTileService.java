package xyz.chz.bfm.service;

import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import android.util.Log;

import xyz.chz.bfm.util.module.ProxyUtil;

public class MyTileService extends TileService {
    public static final String TAG = "MyQSTileService";
    
    @Override
    public void onClick() {
        super.onClick();
        Tile tile = getQsTile(); // get Instance.
        if (tile.getState() == Tile.STATE_INACTIVE) { // Turn on
            ProxyUtil.start(isSucceed -> {
                if (isSucceed) {
                    tile.setState(Tile.STATE_ACTIVE);
                } else {
                    tile.setState(Tile.STATE_INACTIVE);
                }
                tile.updateTile();
            });
        } else {
            ProxyUtil.stop(isSucceed -> {
                if (isSucceed) {
                    tile.setState(Tile.STATE_INACTIVE);
                } else {
                    tile.setState(Tile.STATE_ACTIVE);
                }
                tile.updateTile();
            });
        }
        tile.setState(Tile.STATE_UNAVAILABLE);
        tile.updateTile();
    }
    
    @Override
    public void onTileAdded() {
        super.onTileAdded();
        Log.d(TAG, "added tile server");
    }
    
    @Override
    public void onTileRemoved() {
        super.onTileRemoved();
        Log.d(TAG, "removed tile server");
    }
    
    @Override
    public void onStartListening() {
        super.onStartListening();
        Log.d(TAG, "start.");
        Tile tile = getQsTile();
        
        if (!ProxyUtil.isProxying()) {
            tile.setState(Tile.STATE_INACTIVE);
        } else {
            tile.setState(Tile.STATE_ACTIVE);
        }
        tile.updateTile();
    }
    
    @Override
    public void onStopListening() {
        super.onStopListening();
        Log.d(TAG, "stop.");
        Tile tile = getQsTile(); // get Instance.
        tile.updateTile();
    }
}
