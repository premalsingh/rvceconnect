package com.example.premal2.rvceconnect;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;

public class TeacherPerformanceDashboard extends Fragment
{

    GridView gv;
    TeacherPerformanceAdapter adapter;


    public static TeacherPerformanceDashboard newInstance()
    {
        TeacherPerformanceDashboard fragment = new TeacherPerformanceDashboard();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.teacher_performance_dashboard, container, false);

        gv =(GridView) view.findViewById(R.id.gridviewperformance);

        adapter=new TeacherPerformanceAdapter(view.getContext(),getData());

        gv.setAdapter(adapter);

        return view;
    }


    private ArrayList<SectionCardsForTeacherPerformance> getData()
    {
        ArrayList<SectionCardsForTeacherPerformance> sections=new ArrayList<>();

        SectionCardsForTeacherPerformance s;

        String[] name_of_section=new String[]{"5C","7A","4B","3D"};

        String[] name_of_subject=new String[]{"IPR","BIG DATA","ALGORITHM","DATA STRUCTURES"};

        /*DUMMY*/
        /*retrieve all the student names from the sections  and create arrays*/
        ArrayList<Integer> studentmarks=new ArrayList<>();
        studentmarks.add(40);
        studentmarks.add(30);
        studentmarks.add(45);
        studentmarks.add(15);
        studentmarks.add(29);
        /*write query string to retrieve data from the  database */

        ArrayList<ArrayList<Integer>> studentnameslist=new ArrayList<>();

        for(int i=0;i<name_of_section.length;i++)
        {
            studentnameslist.add(studentmarks);
        }


        int number_of_subjects_handled=name_of_section.length;

        for(int i=0;i<number_of_subjects_handled;i++)
        {
            s=new SectionCardsForTeacherPerformance();
            s.setSectionname(name_of_section[i]);
            s.setSubjectname(name_of_subject[i]);
            s.setStudentmarks(studentnameslist.get(i));
            sections.add(s);
        }

        return sections;
    }







}
