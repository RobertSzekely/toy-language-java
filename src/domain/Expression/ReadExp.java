package domain.Expression;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

import domain.DataTypes.MyIDictionary;
import domain.DataTypes.MyIHeap;
import javafx.application.Platform;
import view.GetNumberInputBox;

public class ReadExp extends Exp {

	//private Scanner in = new Scanner(System.in);
	private  int readNumber;
	
	public ReadExp() {
		//readNumber = in.nextInt();

	}

	@Override
	public int eval(MyIDictionary tbl, MyIHeap heap) throws Exception {

        Platform.runLater(() -> {
            readNumber = GetNumberInputBox.display();

            //if you change the UI, do it here !
        });

       return readNumber;
	}

	@Override
	public String toString() {
		Integer number = readNumber;
		String numberAsString = number.toString();
		//in.close();
		return numberAsString;
	}
	


	
}
