<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-50 font-sans text-gray-700 max-w-3xl mx-auto p-6">
    <h1 class="text-2xl font-semibold text-gray-800 mb-2 text-center">Welcome, ${username}!</h1>
    <p class="text-center mb-8"><a href="LogoutServlet" class="text-red-500 hover:text-red-600 text-sm hover:underline">Logout</a></p>

    <h2 class="text-xl font-medium text-gray-800 border-b border-gray-200 pb-2 mb-4">Available Courses</h2>
    <c:forEach var="course" items="${courses}">
        <div class="flex justify-between items-center border-b border-gray-100 py-3 text-gray-600">
            <span>${course.id} - ${course.name} - ${course.instructor}</span>
            <a href="EnrollServlet?courseId=${course.id}" class="text-teal-600 border border-teal-600 rounded px-3 py-1 text-sm hover:bg-teal-600 hover:text-white transition">Enroll</a>
        </div>
    </c:forEach>

    <h2 class="text-xl font-medium text-gray-800 border-b border-gray-200 pb-2 mb-4 mt-8">Your Enrolled Courses</h2>
    <c:forEach var="course" items="${enrolledCourses}">
        <div class="border-b border-gray-100 py-3 text-gray-600">${course.name} (${course.id})</div>
    </c:forEach>
</body>
</html>