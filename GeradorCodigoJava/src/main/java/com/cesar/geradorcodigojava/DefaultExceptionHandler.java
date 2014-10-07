/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesar.geradorcodigojava;

/**
 *
 * @author cesar
 */
import javax.swing.*;
import java.awt.*;
import java.lang.Thread.*;

public class DefaultExceptionHandler implements UncaughtExceptionHandler {

    public void uncaughtException(Thread t, Throwable e) {
        JOptionPane.showMessageDialog(findActiveFrame(), e.getMessage(), "ERRO", JOptionPane.OK_OPTION);
        e.printStackTrace();
    }

    private Frame findActiveFrame() {
        Frame[] frames = JFrame.getFrames();
        for (int i = 0; i < frames.length; i++) {
            if (frames[i].isVisible()) {
                return frames[i];
            }
        }
        return null;
    }
}
