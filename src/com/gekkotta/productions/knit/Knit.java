package com.gekkotta.productions.knit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

//Displays knitting instructions
public class Knit extends Activity{
	
	int row;
	float progress;
	int totalRows;
	Button nextRow;
	Button prevRow;
	TextView output;
	TextView rowOutput;
	ProgressBar pbar;
	String loc = "Row ";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.knit);
		//RETRIEVE THESE FROM PHONE DATABASE
		row = 0;
		totalRows=20; 
		progress = (row*100)/totalRows;
		
		nextRow = (Button) findViewById(R.id.rowup);
		prevRow = (Button) findViewById(R.id.rowdown);
		output = (TextView) findViewById(R.id.textout);
		rowOutput = (TextView) findViewById(R.id.rowout);
		pbar = (ProgressBar) findViewById(R.id.progressBar1);
		pbar.setMax(100);
		pbar.setProgress((int) progress);
		rowOutput.setText(loc + row);
		
		nextRow.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(row < totalRows){
					row++;
					//Add a call here to save the row progress
					
					String rowInfo="K1,P1,K2,P3";
					//TO DO: Set rowInfo to next set of instructions
					output.setText(rowInfo);
					rowOutput.setText(loc + row);
					
					progress = (row*100)/totalRows;
					pbar.setProgress((int) progress);
				}
			}
		});
		prevRow.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if(row > 0){
					row--;
					//Add a call here to save the row progress
	
					String rowInfo = "K1,P3";
					//TO DO: Set rowInfo to next set of instructions
					output.setText(rowInfo);	
					rowOutput.setText(loc + row);
					
					progress = (row*100)/totalRows;
					pbar.setProgress((int) progress);
				}
			}
		});
	}
}
