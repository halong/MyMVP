package com.example.mymvp.database

import android.annotation.SuppressLint
import android.content.ContentValues

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
        cursor.close()
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
        cursor.close()
        db.close()
        return students
    }

    fun insert(student: Student) {
        val db = SQLiteUtils.mSQLiteOpenHelper.writableDatabase
        val values = ContentValues()
        values.put("name", student.name)
        values.put("age", student.age)
        db.insert("student", "id", values)
        db.close()
    }

    fun insert(students: List<Student>) {
        val db = SQLiteUtils.mSQLiteOpenHelper.writableDatabase
        val values = ContentValues()
        for (student in students) {
            values.put("name", student.name)
            values.put("age", student.age)
            db.insert("student", "id", values)
            values.clear()
        }
        db.close()
    }

    fun delete(name: String) {
        val db = SQLiteUtils.mSQLiteOpenHelper.writableDatabase
        db.delete("student", "name = ?", arrayOf(name))
        db.close()
    }

    fun update(student: Student) {
        val db = SQLiteUtils.mSQLiteOpenHelper.writableDatabase
        val values = ContentValues()
        values.put("name", student.name)
        values.put("age", student.age)
        db.update("student", values, "id=?", arrayOf(student.id.toString()))
        db.close()
    }


}