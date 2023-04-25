import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("10 by 10 matrix");

    GridPane gridPane = new GridPane();
    gridPane.setPrefSize(300, 300);
    gridPane.setPadding(new Insets(10));

    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        CustomPane customPane = new CustomPane();
        gridPane.add(customPane, j, i);
      }
    }

    Scene scene = new Scene(gridPane);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private class CustomPane extends StackPane {
    public CustomPane() {
      Rectangle rectangle = new Rectangle(30, 30, getRandomColor());
      Text text = new Text(Integer.toString(getRandomNumber()));
      text.setFont(Font.font("Calibri", 12));
      text.setFill(Color.WHITE);
      this.getChildren().addAll(rectangle, text);
    }

    private Color getRandomColor() {
      Random random = new Random();
      return Color.color(random.nextDouble(), random.nextDouble(), random.nextDouble(), 0.5);
    }

    private int getRandomNumber() {
      Random random = new Random();
      return random.nextInt(100) + 1;
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
