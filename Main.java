package Arnab.Connect4;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application {
	private Controller controller;
	@Override
	public void start(Stage primaryStage) throws Exception{

		FXMLLoader loader= new FXMLLoader(getClass().getResource("game.fxml"));
		GridPane rootGridPane= loader.load();
		controller= loader.getController();
		controller.createPlayGround();

		MenuBar menuBar=createMenu();
		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());



		Pane menuPane= (Pane) rootGridPane.getChildren().get(0);
		menuPane.getChildren().add(menuBar);

		Scene scene=new Scene(rootGridPane);

		primaryStage.setScene(scene);
		primaryStage.setTitle("connect Four");
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	private MenuBar createMenu(){
		//File Menu
		Menu fileMenu=new Menu("File");

		MenuItem newGame=new MenuItem("New Game");
		newGame.setOnAction(event -> controller.resetGame());

		MenuItem resetGame=new MenuItem("Reset Game");
		resetGame.setOnAction(event -> controller.resetGame());

		SeparatorMenuItem separatorMenuItem= new SeparatorMenuItem();

		MenuItem exitGame= new MenuItem("Exit Game");
		exitGame.setOnAction(event ->exitGame());




		fileMenu.getItems().addAll(newGame ,resetGame, separatorMenuItem,exitGame);

		// Help Menu
		Menu helpMenu=new Menu("Help");

		MenuItem aboutGame=new MenuItem("About Connect4");
		aboutGame.setOnAction(event -> aboutConnect4());


		SeparatorMenuItem separator= new SeparatorMenuItem();
		MenuItem aboutMe= new MenuItem("About Me");
		aboutMe.setOnAction(event -> aboutMe());

		helpMenu.getItems().addAll(aboutGame,separator,aboutMe);

		MenuBar menuBar=new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);

		return menuBar;
	}

	private void aboutMe() {
		Alert alert=new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About The Developer");
		alert.setHeaderText("Arnab Nanda Goswami");
		alert.setContentText("I am Arnab, a student of Kalyani Government Engineering College," +
				" really love to learn new things" +
				" and implements with my own hand in the field of practical aspects" +
				". I really enjoyed a fully enthusiastic rejuvination on the way of making the game." );

		alert.show();
	}

	private void aboutConnect4() {
		Alert alert=new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About Connect Four");
		alert.setHeaderText("How To Play?");
		alert.setContentText("Connect Four is a two-player connection game " +
				"in which the players first choose a color and then take turns " +
				"dropping colored discs from the top into a seven-column," +
				" six-row vertically suspended grid. The pieces fall straight down," +
				" occupying the next available space within the column. " +
				"The objective of the game is to be the first to form a horizontal," +
				" vertical, or diagonal line of four of one's own discs. Connect Four is a solved game. " +
				"The first player can always win by playing the right moves.\n" +
				"\n");
		alert.show();
	}

	private void exitGame() {
		Alert alert = new Alert(Alert.AlertType.NONE);
		alert.setTitle("Warning");
		alert.setHeaderText("Do you really want to exit the application");
		alert.setContentText("Press Yes to exit and press No to retrieve");

		ButtonType yesButton = new ButtonType("Yes");
		ButtonType noButton = new ButtonType("No");

		alert.getButtonTypes().setAll(yesButton,noButton);

		Optional<ButtonType> clickedBtn = alert.showAndWait();

		if(clickedBtn.isPresent() && clickedBtn.get() == yesButton){
			Platform.exit();
			System.exit(0);
		}
	}

	private void resetGame() {
		//TODO
	}

}
