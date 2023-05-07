package com.example.courceregistration;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

    public class MyAdapterRemove extends RecyclerView.Adapter<com.example.courceregistration.MyAdapterRemove.MyViewHolder>{
        private Context context;
        private ArrayList FirstName,LastName,CourseName,CourseCode,StudentYear,Priority,Phone;
        Button message_button;
        public MyAdapterRemove(Context context, ArrayList firstName, ArrayList lastName, ArrayList courseName, ArrayList courseCode, ArrayList studentYear, ArrayList priority, ArrayList phone) {
            this.context = context;
            FirstName = firstName;
            LastName = lastName;
            CourseName = courseName;
            CourseCode = courseCode;
            StudentYear = studentYear;
            Priority = priority;
            Phone = phone;
        }

        @NonNull
        @Override
        public com.example.courceregistration.MyAdapterRemove.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(context).inflate(R.layout.item_remove,parent,false);
            return new com.example.courceregistration.MyAdapterRemove.MyViewHolder(v);
        }
        @Override
        public void onBindViewHolder(@NonNull com.example.courceregistration.MyAdapterRemove.MyViewHolder holder, int position) {
            holder.FirstName.setText(String.valueOf("Student Name: "+FirstName.get(position)));
//        holder.LastName.setText(String.valueOf(LastName.get(position)));
//        holder.CourseName.setText(String.valueOf(CourseName.get(position)));
//        holder.CourseCode.setText(String.valueOf(CourseCode.get(position)));
//        holder.StudentYear.setText(String.valueOf(StudentYear.get(position)));
//        holder.Priority.setText(String.valueOf(Priority.get(position)));
            holder.Phone.setText(String.valueOf("Course Name: "+Phone.get(position)));
            message_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DatabaseHelper Db=new DatabaseHelper(context);
                    Db.deleteStudent(FirstName.get(position).toString());
                    Toast.makeText(context, "Successfully Deleted!", Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return FirstName.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView FirstName,LastName,CourseName,CourseCode,StudentYear,Priority,Phone;
            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                FirstName = itemView.findViewById(R.id.contact_name);
//            LastName = itemView.findViewById(R.id.lastname);
//            CourseName = itemView.findViewById(R.id.coursename);
//            CourseCode = itemView.findViewById(R.id.coursecode);
//            StudentYear = itemView.findViewById(R.id.studentyear);
                // Priority = itemView.findViewById(R.id.priority);
                Phone = itemView.findViewById(R.id.phone);
                message_button=itemView.findViewById(R.id.remove);
            }
        }
    }