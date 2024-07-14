package com.example.calc;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class matrix extends AppCompatActivity {
    Button back, generate, answer;
    EditText matrows, matcolumns, matrows2, matcolumns2;
    float Font_Size = 20f;
    LinearLayout matrixcontainer, matrixcontainer2, matrixcontainer3;
    EditText[][] editmatrix1, editmatrix2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_matrix);
        back = findViewById(R.id.matback);
        generate = findViewById(R.id.matsubmit);
        matrows = findViewById(R.id.rows);
        matcolumns = findViewById(R.id.columns);
        matrows2 = findViewById(R.id.rows2);
        matcolumns2 = findViewById(R.id.columns2);
        matrixcontainer = findViewById(R.id.matrixcontain);
        matrixcontainer2 = findViewById(R.id.matrixcontain2);
        matrixcontainer3 = findViewById(R.id.matrixcontain3);
        answer  = findViewById(R.id.ans);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(matrix.this, MainActivity2.class);
                startActivity(intent1);
            }
        });
        generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generatematrices();
            }
        });
        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                multiplyMatrix();
            }
        });
    }
    void generatematrices(){
        genrateMatrix(matrows, matcolumns, matrixcontainer, true);
        genrateMatrix(matrows2, matcolumns2, matrixcontainer2, false);
    }

    @SuppressLint("DefaultLocale")
    private void genrateMatrix(EditText matfinalrows, EditText matfinalcolumns, LinearLayout matrixfinalcontainer, boolean isfirstmatrix) {
        matrixfinalcontainer.removeAllViews();
        int rows = Integer.parseInt(matfinalrows.getText().toString());
        int columns = Integer.parseInt(matfinalcolumns.getText().toString());
        EditText[][] editmatrix = new EditText[rows][columns];
        TableLayout tableLayout = new TableLayout(this);
        tableLayout.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));
        for(int i = 0; i < rows; i++) {
            TableRow tablerow = new TableRow(this);
            tablerow.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            for (int j = 0; j < columns; j++) {
                EditText editText = new EditText(this);
                editText.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                editText.setHint(String.format("R%dC%d", i + 1, j + 1));
                editText.setTextSize(Font_Size);
                editText.setPadding(8, 8, 8, 8);
                tablerow.addView(editText);
                editText.setGravity(Gravity.CENTER);
                editText.setInputType(InputType.TYPE_CLASS_NUMBER);
                editmatrix[i][j] = editText;
            }
            tableLayout.addView(tablerow);
        }
        matrixfinalcontainer.addView(tableLayout);
        if(isfirstmatrix){
            editmatrix1 = editmatrix;
        }else{
            editmatrix2 = editmatrix;
        }
    }
    int[][] getmatrixvalue(EditText[][] editTextMatrix){
        if(editTextMatrix == null){
            return null;
        }
        int rows = editTextMatrix.length;
        int columns = editTextMatrix[0].length;
        int[][] matrixValues = new int[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                String value = editTextMatrix[i][j].getText().toString();
                matrixValues[i][j] = TextUtils.isEmpty(value) ? 0 : Integer.parseInt(value);
            }
        }
        return matrixValues;
    }
    void multiplyMatrix(){
        int[][] matrix1 = getmatrixvalue(editmatrix1);
        int[][] matrix2 = getmatrixvalue(editmatrix2);
        if(matrix1 == null || matrix2 == null){
            return;
        }
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int row2 = matrix2.length;
        int col2 = matrix2[0].length;
        if(col1 != row2){
            return;
        }
        int[][] result  = new int[row1][col2];
        for(int i = 0; i < row1; i++){
            for(int j = 0; j < col2; j++){
                for(int k = 0; k < row2; k++){
                    result[i][j] += matrix1[i][k]*matrix2[k][j];
                }
            }
        }
        displayMatrix(result);
    }
    void displayMatrix(int[][] resultMatrix){
        matrixcontainer3.removeAllViews();
        TableLayout tableLayout = new TableLayout(this);
        tableLayout.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT));
        for(int i = 0; i < resultMatrix.length; i++){
            TableRow tablerow = new TableRow(this);
            tablerow.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT));
            for(int j = 0; j < resultMatrix[0].length; j++){
                TextView textview = new TextView(this);
                textview.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT));
                textview.setText(String.valueOf(resultMatrix[i][j]));
                textview.setPadding(8, 8, 8, 8);
                textview.setTextSize(Font_Size);
                textview.setGravity(Gravity.CENTER);
                tablerow.addView(textview);
            }
            tableLayout.addView(tablerow);
        }
        matrixcontainer3.addView(tableLayout);
    }
}