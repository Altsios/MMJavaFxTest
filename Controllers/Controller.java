package MathMethods.Controllers;

import MathMethods.Model.*;
import MathMethods.Utils.WinOps;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller extends WinOps implements Initializable {

    @FXML
    private TextField start;

    @FXML
    private TextField end;

    @FXML
    private TextField step;

    @FXML
    private TextField scale;

    @FXML
    private Button shbutt;

    @FXML
    private Button nxtbtn;

    @FXML
    private Button nxtbtnFst;

    @FXML
    private ListView<String> mylst;

    @FXML
    private ListView<String> lst;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        lst.setItems(FXCollections.observableArrayList(
                "Линейная", "Экспоненциальная", "Случайный процесс", "Гармонический процесс"));

        mylst.setItems(FXCollections.observableArrayList(
                "4 графика функций", "Автокорреляция/Ковариация\n случайных процессов"));
    }


    @FXML
    private void nextBtnPressedFst(ActionEvent event) {

        int idx = lst.getSelectionModel().getSelectedIndex();


        switch (idx) {

            case 0:
                LinProc(event);
                break;

            case 1:
                System.out.println(1);
                break;

            case 2:
                System.out.println(2);
                break;

            case 3:
                HarmProc(event);
                break;

            default:
                warning();
                break;

        }

    }

    @FXML
    private void nextBtnPressed(ActionEvent event) {

        int idx = mylst.getSelectionModel().getSelectedIndex();


        switch (idx) {

            case 0:
                System.out.println(0);
                break;

            case 1:
                ShR(event);
                break;

            case 2:
                System.out.println(2);
                break;

            default:
                warning();
                break;

        }


    }


    private float[] MakexCoord(float[] inpvals) {

        int N = (int) (inpvals[1] - inpvals[0] + 1);
        float[] x = new float[N];

        x[0] = inpvals[0];

        for (int i = 1; i < N; i++)
            x[i] = x[i - 1] + inpvals[2];

        return x;
    }

    private void LinProc(ActionEvent event) {
        try {
            float[] inpvals = GetInputs("../fxml/Linear.fxml", 6, event, 198, 295);

            float[] x = MakexCoord(inpvals);

            Linear h = new Linear(x, inpvals[3], inpvals[4]);

            FXMLLoader loader = LOADER("../fxml/TaskFTrend.fxml");
            Parent root = loader.load();
            TasksCntr cont = loader.getController();
            cont.setRef(h,"Линейная функция");
            OpenWin("Действие", event, 283, 280, root);

            //TODO: открыть окно с выбором действия
        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }


    private void HarmProc(ActionEvent event) {
        try {
        float[] inpvals = GetInputs("../fxml/Harmonic.fxml", 6, event, 198, 295);

        float[] x = MakexCoord(inpvals);

        Harmonic h = new Harmonic(x, inpvals[3], inpvals[4], inpvals[5]);

        FXMLLoader loader = LOADER("../fxml/TaskFTrend.fxml");
        Parent root = loader.load();
        TasksCntr cont = loader.getController();
        cont.setRef(h,"Гармонический процесс");
        OpenWin("Действие", event, 283, 280, root);

        //TODO: открыть окно с выбором действия
        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }

    private float[] GetInputs(String path, int N, ActionEvent event,
                              int minWidth, int minHeight) throws IOException {

        float[] inpvals = new float[N];
        FXMLLoader loader = LOADER(path);
        Parent root = loader.load();
        ParamCntr cont = loader.getController();
        cont.setRef(inpvals);

        OpenWin("Параметры", event, minWidth, minHeight, root);

        return inpvals;
    }


    private void ShR(ActionEvent event) {

        float[] inpvals;
        try {
            inpvals = GetInputs("../fxml/Random.fxml", 4, event, 198, 221);

            float[] x = MakexCoord(inpvals);

            MyRand mr1 = new MyRand(x, inpvals[3]);
            Rand r1 = new Rand(x, inpvals[3]);

            MyRand mr2 = new MyRand(x, inpvals[3]);
            Rand r2 = new Rand(x, inpvals[3]);

            OpenFourWIn(event,new String[]{"Автокорреляция: Свой рандом",
                    "Автокорреляция: Встроенный рандом",
                    "Ковариация: Свой рандом","Ковариация: Встроенный рандом"},
                    new Trend[]{mr1.Rxx(), r1.Rxx(), Trend.Rxy(mr1, mr2),Trend.Rxy(r1, r2)});

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
