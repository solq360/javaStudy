//package org.solq.lesson16;
//
//import javafx.application.Application;
//import javafx.application.Platform;
//import javafx.scene.Scene;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.web.WebEngine;
//import javafx.scene.web.WebView;
//import javafx.stage.Stage;
//import netscape.javascript.JSObject;
//
//public class WebApp extends Application {
//	static WebView webView = new WebView();
//	static WebEngine webEngine = webView.getEngine();
//
//	@Override
//	public void start(Stage primaryStage) throws Exception {
//		String url = getClass().getResource("../html/main.html").toExternalForm();
//		// System.out.println(url);
//		registerJsCallJava();
//
//		webEngine.load(url); // ????????????
//		BorderPane root = new BorderPane();
//		root.setCenter(webView);
//		Scene scene = new Scene(root, 960, 600);
//		primaryStage.setScene(scene);
//		primaryStage.show();
//	}
//
////	void registerJsCallJava() {
////		JSObject win = (JSObject) webEngine.executeScript("window");
////		win.setMember("app", new JavaApp());
////	}
////
////	void callJs(String script) {
////		Object ret = webEngine.executeScript(script);
////		System.out.println(ret);
////	}
////
////	static public class JavaApp {
////		public void exit() {
////			Platform.exit();
////		}
////
////		public void call(String str, int num, int[] ar) {
////			System.out.println("str:" + str);
////			System.out.println("num:" + num);
////			System.out.println("ar:" + ar);
////		}
////
////		public void callJs(String script) {
////			Object ret = webEngine.executeScript(script);
////			System.out.println(ret);
////		}
////
////	}
//
//	public static void main(String[] args) {
//		launch(args);
//	}
//}