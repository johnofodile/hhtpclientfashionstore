package com.example.fashionstoreclientside.Model;

import com.example.fashionstoreclientside.ClientUI;

public class MainApplication {
    public static void main(String[] args) {
        System.out.println("Here comes our fashion store");
        ClientUI clientUI = new ClientUI();
        clientUI.menu();

    }
}
