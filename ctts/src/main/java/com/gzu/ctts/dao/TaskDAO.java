package com.gzu.ctts.dao;

import com.gzu.ctts.entity.Task;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO {

    private static final String URL = "jdbc:mysql://ctts-mysql:3306/ctts?characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    // 获取所有任务
   /* public List<Task> getTasks() {
        List<Task> list = new ArrayList<>();
        String SQL = "SELECT id, project_id, title, description, deadline, total_score, `status`,create_time, update_time FROM task";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        // 1.加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 获取连接
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            // 3. 准备SQL
            preparedStatement = connection.prepareStatement(SQL);
            // 4. 执行查询
            rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Task task = new Task();
                task.setId(rs.getLong("id"));
                task.setProjectId(rs.getLong("project_id"));
                task.setTitle(rs.getString("title"));
                task.setDescription(rs.getString("description"));
                task.setDeadline(rs.getObject("deadline", LocalDateTime.class));
                task.setTotalScore(rs.getInt("total_score"));
                task.setStatus(rs.getInt("status"));
                task.setCreateTime(rs.getObject("create_time", LocalDateTime.class));
                task.setUpdateTime(rs.getObject("update_time", LocalDateTime.class));
                list.add(task);
            }
            return list;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }*/


    public static void main(String[] args) {
    }

    /*public Task getTaskById(Long id) {
        String SQL = "SELECT id, project_id, title, description, deadline, total_score, `status`,create_time, update_time FROM task WHERE id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        // 1.加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 获取连接
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            // 3. 准备SQL
            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setLong(1, id);
            // 4. 执行查询
            rs = preparedStatement.executeQuery();

            Task task = new Task();

            while (rs.next()) {
                task.setId(rs.getLong("id"));
                task.setProjectId(rs.getLong("project_id"));
                task.setTitle(rs.getString("title"));
                task.setDescription(rs.getString("description"));
                task.setDeadline(rs.getObject("deadline", LocalDateTime.class));
                task.setTotalScore(rs.getInt("total_score"));
                task.setStatus(rs.getInt("status"));
                task.setCreateTime(rs.getObject("create_time", LocalDateTime.class));
                task.setUpdateTime(rs.getObject("update_time", LocalDateTime.class));
            }
            return task;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }*/

   /* public void addTask(Task task) {
        String SQL = "INSERT INTO task(project_id, title, description, deadline, total_score, `status`, create_time, update_time) VALUE(?,?,?,?,?,?,?,?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(SQL);
            preparedStatement.setLong(1, task.getProjectId());
            preparedStatement.setString(2, task.getTitle());
            preparedStatement.setString(3, task.getDescription());
            preparedStatement.setObject(4, task.getDeadline());
            preparedStatement.setInt(5, task.getTotalScore());
            preparedStatement.setInt(6, task.getStatus());
            preparedStatement.setObject(7, task.getCreateTime());
            preparedStatement.setObject(8, task.getUpdateTime());

            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                connection.commit();
                System.out.println("添加成功");
            }

        } catch (SQLException e) {

            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            throw new RuntimeException(e);
        } finally {

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            try {
                if (connection != null) {
                    connection.setAutoCommit(true);
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
*/

}
