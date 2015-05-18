package com.example.adapter;

import com.baidu.navisdk.comapi.tts.BNTTSPlayer;
import com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener;

public class myIBNTTSPlayerListener implements IBNTTSPlayerListener {

	@Override
    public int playTTSText(String arg0, int arg1) {
    	//开发者可以使用其他TTS的API
    	
        return BNTTSPlayer.playTTSText(arg0, arg1);
    }
    
    @Override
    public void phoneHangUp() {
        //手机挂断
    }
    
    @Override
    public void phoneCalling() {
    }

	@Override
	public int getTTSState() {
		//开发者可以使用其他TTS的API,
        return BNTTSPlayer.getTTSState();
	}


}
