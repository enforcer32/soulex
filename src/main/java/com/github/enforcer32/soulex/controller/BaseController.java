package com.github.enforcer32.soulex.controller;

import com.github.enforcer32.soulex.app.SceneManager;

public abstract class BaseController {
    protected SceneManager sceneManager;

    public void setSceneManager(SceneManager sceneManager) { this.sceneManager = sceneManager; }
}
