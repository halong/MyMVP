package com.example.mymvp.database

import android.annotation.SuppressLint

object StudentDao {
    @SuppressLint("Recycle")
    fun findById(id: Int): Student? {
        val db = SQLiteUtils.mSQLiteOpenHelper.readableDatabase
        val cursor = db.query("student", null, "id=$id", null, null, null, null)
        val idIndex = cursor.getColumnIndex("id")
        val nameIndex = cursor.getColumnIndex("name")
        val ageIndex = cursor.getColumnIndex("age")
        cursor.moveToFirst()
        var student: Student? = null
        while (!cursor.isAfterLast) {
            student = Student(
                cursor.getInt(idIndex),
                cursor.getString(nameIndex),
                cursor.getInt(ageIndex)
            )
            cursor.moveToNext()
        }
        db.close()
        return student
    }

    @SuppressLint("Recycle")
    fun findAll(): List<Student> {
        val db = SQLiteUtils.mSQLiteOpenHelper.readableDatabase
        val students = ArrayList<Student>()
        val cursor = db.query("student", null, null, null, null, null, "id asc")
        val idIndex = cursor.getColumnIndex("id")
        val nameIndex = cursor.getColumnIndex("name")
        val ageIndex = cursor.getColumnIndex("age")

        cursor.moveToFirst()
        while (!cursor.isAfterLast) {
            val student = Student(
                cursor.getInt(idIndex),
                cursor.getString(nameIndex),
                cursor.getInt(ageIndex)
            )
            students.add(student)
            cursor.moveToNext()
        }
        db.close()
        return students
    }

    fun insert(student: Student){

    }

    fun delete(){

    }

    fun update(){

    }


}