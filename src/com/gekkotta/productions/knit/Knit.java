package com.gekkotta.productions.knit;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Knit extends Activity{
	
	int row;
	int progress;
	int totalRows;
	Button nextRow;
	Button prevRow;
	TextView output;
	TextView rowOutput;
	ProgressBar pbar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.knit);
		//RETRIEVE THESE FROM PHONE DATABASE
		row = 10;
		totalRows=20; 
		
		progress = (row/totalRows) * 100;
		
		nextRow = (Button) findViewById(R.id.rowup);
		prevRow = (Button) findViewById(R.id.rowdown);
		output = (TextView) findViewById(R.id.textout);
		rowOutput = (TextView) findViewById(R.id.rowout);
		pbar = (ProgressBar) findViewById(R.id.progressBar1);
		
		
		pbar.setProgress(progress);
		
		nextRow.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				row++;
				//Add a call here to save the row progress
				
				String loc = "Row" + row;
				String rowInfo="K1,P1,K2,P3";
				//TO DO: Set rowInfo to next set of instructions
				output.setText(rowInfo);
				rowOutput.setText(loc);
				
				progress = (row/totalRows) * 100;
				pbar.setProgress(progress);
			}
		});
		prevRow.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				row--;
				//Add a call here to save the row progress
				
				String loc = "Row" + row;
				String rowInfo = "K1,P3";
				//TO DO: Set rowInfo to next set of instructions
				output.setText(rowInfo);
				rowOutput.setText(loc);
				
				progress = (row/totalRows) * 100;
				pbar.setProgress(progress);;
			}
		});
	}
}
