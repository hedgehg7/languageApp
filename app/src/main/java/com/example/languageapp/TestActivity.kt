package com.example.languageapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class TestActivity : AppCompatActivity() {
    private lateinit var questions: Array<String>
    private lateinit var answers: Array<Array<String>>
    private lateinit var correctAnswers: IntArray

    private var currentTest = 0
    private var correctLevel = 1


    private lateinit var questionCounter: TextView
    private lateinit var correctCounter: TextView
    private lateinit var questionText: TextView
    private lateinit var answersGroup: RadioGroup
    private lateinit var checkButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val lessonId = intent.getStringExtra("lessonId") ?: "TestTwo"
        loadLessonData(lessonId)

        questionCounter = findViewById(R.id.questionCounter)
        correctCounter = findViewById(R.id.correctCounter)
        questionText = findViewById(R.id.questionText)
        answersGroup = findViewById(R.id.answersGroup)
        checkButton = findViewById(R.id.checkButton)

        loadQuestion()

        checkButton.setOnClickListener {
            when (checkButton.text.toString()) {
                "Check" -> checkAnswer()
                "Next" -> nextQuestion()
            }
        }
    }

    private fun loadLessonData(lessonId: String) {
        when (lessonId) {
            "TestOne" -> {
                questions = arrayOf(
                    "What does 'Software' refer to?",
                    "What is 'Hardware' in computing?",
                    "What is 'Code' used for?",
                    "What does 'Bug' mean in programming?",
                    "What does 'Fix' mean in software development?",
                    "What does 'Issue' refer to in a development process?",
                    "What is a 'Feature' in a software application?",
                    "What does 'Release' mean in software development?",
                    "What is a 'Repository' used for?",
                    "What does 'Commit' mean in version control?",
                    "What does 'Merge' mean in Git?",
                    "What does 'Set up' mean in programming?",
                    "What does 'Figure out' mean in coding?",
                    "What does 'Run into' mean in troubleshooting?",
                    "What does 'Debugging' help with?",
                    "What does 'Before release' mean?",
                    "What does 'Unexpected behavior' mean in programming?",
                    "What is the purpose of 'Testing' in development?",
                    "Why do developers use 'Error logs'?",
                    "What is the main goal of a 'Code review'?"
                )

                answers = arrayOf(
                    arrayOf("A physical part of a computer", "A set of instructions for a computer", "A type of processor", "A network device"),
                    arrayOf("A programming language", "A physical part of a computer", "A software application", "A database system"),
                    arrayOf("To design user interfaces", "To translate data", "To give instructions to a computer", "To store data permanently"),
                    arrayOf("A security issue", "An error in the code", "A type of hardware", "A feature of the program"),
                    arrayOf("To create new features", "To remove unnecessary files", "To correct an error", "To test performance"),
                    arrayOf("A new function", "A problem in the software", "A security vulnerability", "A network delay"),
                    arrayOf("An error in the code", "A new function or capability", "A type of software license", "A database structure"),
                    arrayOf("A new version of the software", "A type of computer", "A debugging process", "A security update"),
                    arrayOf("A backup storage for files", "A storage location for code versions", "A cloud computing service", "A security feature"),
                    arrayOf("To finalize and save code changes", "To test a program", "To delete old versions", "To log errors"),
                    arrayOf("To separate branches", "To combine different code changes", "To test software", "To remove errors"),
                    arrayOf("To configure a system", "To delete files", "To install a virus", "To compress data"),
                    arrayOf("To understand a problem", "To create a new project", "To delete old files", "To speed up the system"),
                    arrayOf("To solve an issue", "To physically hit the computer", "To improve network speed", "To change database settings"),
                    arrayOf("To find and fix bugs", "To write documentation", "To create a new project", "To test security"),
                    arrayOf("After the program is launched", "Before the software is published", "During installation", "When the program crashes"),
                    arrayOf("An expected function of a program", "A malfunction in the software", "A security feature", "A development stage"),
                    arrayOf("To add security", "To check the software for errors", "To increase speed", "To delete old code"),
                    arrayOf("To remove old files", "To help identify and fix problems", "To store code versions", "To create a backup"),
                    arrayOf("To find mistakes and improve code", "To delete unnecessary files", "To run a virus scan", "To improve internet speed")
                )
                correctAnswers = intArrayOf(1, 1, 2, 1, 2, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0)
            }
            "TestTwo" -> {
                questions = arrayOf(
                    "What is a framework in programming?",
                    "What does an API allow one program to do?",
                    "What is the purpose of a function in programming?",
                    "What is the role of a variable in a program?",
                    "What is a loop used for in programming?",
                    "What is a condition in a program?",
                    "What is an exception in programming?",
                    "What is the process of deployment?",
                    "What does 'rollback' refer to in software development?",
                    "What does 'refactoring' mean in programming?",
                    "What does 'pushing changes to the repo' mean?",
                    "Why is handling exceptions properly important?",
                    "What does 'writing test cases' refer to?",
                    "What does 'deploying the app' involve?",
                    "What does 'rolling back to the previous version' mean?",
                    "What is the significance of an API in modern development?",
                    "What is a library in programming?",
                    "What does 'return' do in a function?",
                    "What is the main benefit of using a loop?",
                    "What happens if an exception is not properly handled?"
                )
                answers = arrayOf(
                    arrayOf("A set of libraries and tools for building applications", "A system for organizing data", "A type of variable in a program", "A method for debugging"),
                    arrayOf("It allows programs to communicate with each other", "It stores program data", "It helps in compiling the code", "It tracks system performance"),
                    arrayOf("It performs a specific task in the program", "It stores data temporarily", "It checks the program for errors", "It organizes the data"),
                    arrayOf("It stores data that can be used during the program’s execution", "It checks conditions in the program", "It repeats tasks in the program", "It compiles the code"),
                    arrayOf("It repeats a set of instructions multiple times", "It sorts data in a program", "It checks for errors in a program", "It retrieves information from the database"),
                    arrayOf("It allows the program to make decisions based on certain conditions", "It stores temporary data", "It organizes functions", "It runs a program on a specific device"),
                    arrayOf("It is a type of error that occurs during execution", "It is a function that returns a result", "It is a data structure", "It is a process that tracks program flow"),
                    arrayOf("Moving an app from a development environment to production", "Testing a program’s features", "Optimizing a program for performance", "Removing unused code from a program"),
                    arrayOf("Reverting a system to a previous state", "Updating software to the latest version", "Changing the program’s core functionality", "Improving the app’s security"),
                    arrayOf("Improving the code without changing its behavior", "Deleting unnecessary code from the program", "Adding new features to the app", "Upgrading a system’s hardware"),
                    arrayOf("Sending code changes to a shared repository", "Backing up the code to a cloud service", "Testing the code before publishing", "Debugging a function in the code"),
                    arrayOf("It ensures the program continues to function even when errors occur", "It improves the speed of the program", "It makes the code easier to understand", "It helps organize the code into functions"),
                    arrayOf("Creating tests to ensure the code works as expected", "Optimizing the program’s performance", "Organizing the functions in the program", "Writing documentation for the program"),
                    arrayOf("Preparing the app for users to download and use", "Writing unit tests for the app’s functions", "Optimizing the app’s user interface", "Creating a backup of the app’s data"),
                    arrayOf("Reverting to a previous working version of the app", "Upgrading the app to the latest version", "Testing a new feature", "Changing the app’s settings"),
                    arrayOf("It allows programs to access and use external features", "It processes and compiles code", "It stores temporary data for applications", "It helps in debugging the program"),
                    arrayOf("A set of pre-written code to simplify development", "A data structure used to store information", "A process of checking program syntax", "A method for handling exceptions"),
                    arrayOf("It sends a value back to the calling code", "It processes user input", "It prints data to the screen", "It checks conditions in a program"),
                    arrayOf("It helps to reduce code repetition", "It improves the program’s memory usage", "It checks for errors in a program", "It makes the code less readable"),
                    arrayOf("The program may crash or behave unexpectedly", "The program will continue without issue", "The program will start over", "The program will create a new file")
                )
                correctAnswers = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
            }
            "TestThree" -> {
                questions = arrayOf(
                    "What term refers to a structure for software development?",
                    "What does the word 'library' mean in programming?",
                    "How do you translate 'API' into Russian?",
                    "What does a function do in programming?",
                    "What is a variable in code?",
                    "What type of loop repeats based on a condition?",
                    "What is a condition in code?",
                    "What does 'exception' mean in programming?",
                    "What is the process of sending changes to the repository called?",
                    "What does 'refactor the code' mean?",
                    "What happens if an exception occurs when running the program?",
                    "What is 'push changes to the repo'?",
                    "What does 'handle exceptions properly' mean?",
                    "What is the process of launching a program in a production environment called?",
                    "What is 'rollback' in programming?",
                    "What is 'debugging'?",
                    "What is a 'branch' in version control systems?",
                    "What process allows automatically testing code with every change?",
                    "What does 'write test cases' mean?",
                    "What is 'continuous integration'?"
                )
                answers = arrayOf(
                    arrayOf("Framework", "API", "Library", "Function"),
                    arrayOf("A collection of functions", "A tool for testing", "A program", "A set of rules"),
                    arrayOf("Interface for communication between programs", "A type of variable", "A loop structure", "A piece of software"),
                    arrayOf("It returns a result", "It checks the condition", "It repeats actions", "It defines a function"),
                    arrayOf("A storage for data", "A block of code", "A temporary place for information", "A type of function"),
                    arrayOf("For loop", "While loop", "If statement", "Switch statement"),
                    arrayOf("A decision point in code", "A loop", "A function", "A type of exception"),
                    arrayOf("An error during execution", "A type of condition", "A result of a function", "A program feature"),
                    arrayOf("Push changes to the main branch", "Send updates to the repository", "Define the variables", "Commit changes"),
                    arrayOf("Rewrite the code for better structure", "Run the code in production", "Fix all the bugs", "Write new features"),
                    arrayOf("The program stops working", "The program continues with default values", "A part of the program handles the error", "The code is ignored"),
                    arrayOf("Send your changes to the repository", "Test the code", "Refactor the code", "Make a new version of the app"),
                    arrayOf("Handle all errors manually", "Handle errors by restarting the program", "Ensure that exceptions are correctly processed", "Ignore the errors"),
                    arrayOf("Launch the program on users' devices", "Write tests for the program", "Install the software", "Deploy the program in a testing environment"),
                    arrayOf("Go back to the previous working version", "Revert all changes", "Check if the new version works", "Test the system before release"),
                    arrayOf("The process of fixing bugs", "The process of adding new features", "The process of deploying the code", "The process of reviewing code"),
                    arrayOf("A version of the program", "A new set of changes in the code", "A branch in the repository", "A way to test the code automatically"),
                    arrayOf("A process to review and improve code", "A process to create new features", "A way to organize code", "A tool for testing code"),
                    arrayOf("Automatically building and testing the software", "Testing the software manually", "Deploying the code to production", "Rewriting the code for performance")
                )
                correctAnswers = intArrayOf(0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 2, 1, 2, 0, 1, 0, 0, 1, 0, 0)
            }

            "TestFour" -> {
                questions = arrayOf(
                    "What does 'specification' mean in technical documentation?",
                    "What is a 'requirement' in software development?",
                    "How do you define 'constraint' in the context of a project?",
                    "What is an 'assumption' in technical specifications?",
                    "What does 'configuration' refer to in system setup?",
                    "What is the 'setup' process in software installation?",
                    "How is 'integration' defined in technical documentation?",
                    "What is the difference between 'authentication' and 'authorization'?",
                    "What does it mean to 'set up authentication'?",
                    "What does 'access token' mean in the context of APIs?",
                    "What is the purpose of the 'request header' in HTTP requests?",
                    "What does 'ensure that the token is included in the request header' imply?",
                    "What is the role of 'authorization' in system security?",
                    "What is 'multi-factor authentication'?",
                    "How do you interpret 'security policy' in system documentation?",
                    "What is the purpose of 'backup configurations' before updates?",
                    "What does 'load testing' mean in the context of software development?",
                    "What is meant by 'overwriting existing settings' during an update?",
                    "What is a 'payment gateway' in technical documentation?",
                    "What does 'external payment gateways' refer to?"
                )
                answers = arrayOf(
                    arrayOf("The description of system functions", "A type of system requirement", "A set of rules for development", "A summary of requirements"),
                    arrayOf("A feature the system must have", "A tool used for testing", "A process for handling errors", "A suggestion for developers"),
                    arrayOf("A limitation on the project's scope", "A recommendation for performance", "A description of the system's architecture", "A description of user interactions"),
                    arrayOf("A condition taken for granted", "A test scenario", "A restriction on system resources", "A required system update"),
                    arrayOf("The arrangement of system components", "A type of security protocol", "A method for debugging code", "A document of system guidelines"),
                    arrayOf("The process of installing software", "The process of configuring settings", "The process of setting up network connections", "The process of documenting system features"),
                    arrayOf("The process of making two systems work together", "The process of fixing bugs", "The process of testing system security", "The process of coding in multiple languages"),
                    arrayOf("Authentication is for confirming identity, authorization is for granting access", "Authentication checks if the user has permissions", "Authorization determines what resources can be accessed", "Authentication and authorization are the same"),
                    arrayOf("To verify the identity of a user or system", "To define user permissions", "To manage user accounts", "To secure system configurations"),
                    arrayOf("A unique code used for validating requests", "A form of password", "A user role identifier", "A user credentials file"),
                    arrayOf("It holds metadata about the request", "It contains data sent from the user", "It checks the validity of the request", "It encrypts the content of the request"),
                    arrayOf("It means the token must be included for the request to be valid", "It ensures the security of the data being sent", "It checks the permissions of the sender", "It validates the user's credentials"),
                    arrayOf("Authorization grants permissions after successful authentication", "Authorization determines if a user can access a resource", "Authorization secures a system from attacks", "Authorization handles token validation"),
                    arrayOf("A method of securing login by requiring multiple validation factors", "A type of encryption for user data", "A process to ensure account safety", "A mechanism for logging out users"),
                    arrayOf("A set of rules designed to secure data and access", "A collection of instructions for system setup", "A set of configurations to enhance performance", "A type of system update protocol"),
                    arrayOf("To preserve all system settings before changes are made", "To encrypt user data", "To restart the system", "To monitor system behavior after updates"),
                    arrayOf("It means testing the system with a large volume of users", "It means measuring the system's speed", "It means finding errors in the system", "It means ensuring the system's functionality"),
                    arrayOf("It means replacing old settings with new ones", "It means backing up system data", "It means improving system functionality", "It means updating security policies"),
                    arrayOf("A service for processing payments online", "A method for transferring money", "A mechanism for checking payment details", "A platform for tracking payments"),
                    arrayOf("Systems that handle transactions between customers and merchants", "Online banking services", "Systems that process online orders", "Payment platforms for cryptocurrencies")
                )
                correctAnswers = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
            }
            "TestFive" -> {
                questions = arrayOf(
                    "What is the main goal of the debug process?",
                    "What information does the log file contain?",
                    "What is the purpose of setting breakpoints in debugging?",
                    "What is a typical reason for an application crash?",
                    "What does 'timeout' refer to in the context of web requests?",
                    "How do you reduce latency in a database query?",
                    "What is a bottleneck in system performance?",
                    "How can you improve the performance of an application?",
                    "What is the role of the error message in troubleshooting?",
                    "What does 'trace' mean in debugging?",
                    "What is the difference between a crash and a timeout?",
                    "Why is it important to check error logs when an application fails?",
                    "What is latency in the context of a network application?",
                    "How does a bottleneck affect the performance of a system?",
                    "What steps can you take to debug a program effectively?",
                    "What does 'track the flow of execution' mean in debugging?",
                    "How does a breakpoint help during the debugging process?",
                    "What does optimizing performance involve in the context of web applications?",
                    "What is meant by 'reducing latency' in network-based applications?",
                    "Why are timeout settings important in a distributed system?"
                )
                answers = arrayOf(
                    arrayOf("Finding and fixing bugs", "Tracking system performance", "Analyzing code syntax", "Improving database queries"),
                    arrayOf("User data", "Error messages", "Function outputs", "Debug information"),
                    arrayOf("To stop the execution and examine variables", "To improve the code logic", "To restart the program", "To speed up execution"),
                    arrayOf("Uncaught exception", "Corrupt data", "Lack of resources", "Null pointer exception"),
                    arrayOf("Time taken to execute a request", "Time limit for database operations", "Maximum allowed query length", "Maximum allowed file size"),
                    arrayOf("Increase the number of indexes", "Optimize query logic", "Reduce database load", "Change server configuration"),
                    arrayOf("A problem with memory allocation", "A part of the program that limits performance", "A user interface issue", "An unhandled exception"),
                    arrayOf("Rewrite the code", "Simplify the logic", "Increase resource usage", "Fix errors in the code"),
                    arrayOf("Indicating a problem", "Providing a solution", "Describing the system status", "Logging execution steps"),
                    arrayOf("Tracking function calls and variables", "Displaying errors", "Stopping the code", "Providing system performance statistics"),
                    arrayOf("Crash is caused by an error that stops the application", "Timeout is caused by a delayed response", "Crash is a software feature", "Timeout happens only during system shutdown"),
                    arrayOf("It contains details that help identify the issue", "It prevents the system from restarting", "It stores the program’s source code", "It saves the current user settings"),
                    arrayOf("The delay in data transfer", "The frequency of requests", "The speed of the internet connection", "The processing time of the server"),
                    arrayOf("It creates bottlenecks", "It slows down the data processing", "It increases system efficiency", "It monitors user behavior"),
                    arrayOf("Use debugging tools", "Write more tests", "Change the environment variables", "Add more features"),
                    arrayOf("Analyze each function's execution step", "Test new features", "Fix user interface bugs", "Optimize memory usage"),
                    arrayOf("It allows stepping through the program", "It logs errors during execution", "It increases program speed", "It restarts the program"),
                    arrayOf("Improving database indexing", "Reducing unnecessary data transfers", "Compressing large files", "Adding more memory to the server"),
                    arrayOf("Reducing the time delay in communication", "Increasing network bandwidth", "Improving security protocols", "Adding more servers to the network"),
                    arrayOf("To prevent system overloads", "To ensure timely response from services", "To guarantee data security", "To improve user experience")
                )
                correctAnswers = intArrayOf(0, 1, 0, 2, 0, 1, 1, 3, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1)
            }
        }
    }

    private fun loadQuestion() {
        questionCounter.text = "${currentTest + 1}/${questions.size}"
        questionText.text = questions[currentTest]

        for (i in 0 until answersGroup.childCount) {
            val radioButton = answersGroup.getChildAt(i) as RadioButton
            radioButton.text = answers[currentTest][i]
            radioButton.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent))
        }

        answersGroup.clearCheck()
        checkButton.text = "Check"
    }

    private fun checkAnswer() {
        val selectedId = answersGroup.checkedRadioButtonId
        if (selectedId == -1) {
            Toast.makeText(this, "Please select an answer!", Toast.LENGTH_SHORT).show()
            return
        }

        val selectedAnswer = answersGroup.indexOfChild(findViewById(selectedId))
        val correctAnswerIndex = correctAnswers[currentTest]

        if (selectedAnswer == correctAnswerIndex) {
            correctLevel++
            correctCounter.text = "Correct: $correctLevel"
            (answersGroup.getChildAt(selectedAnswer) as RadioButton).setBackgroundColor(
                ContextCompat.getColor(this, R.color.green)
            )
        } else {
            (answersGroup.getChildAt(selectedAnswer) as RadioButton).setBackgroundColor(
                ContextCompat.getColor(this, R.color.holo_red_light)
            )
            (answersGroup.getChildAt(correctAnswerIndex) as RadioButton).setBackgroundColor(
                ContextCompat.getColor(this, R.color.green)
            )
        }
        checkButton.text = "Next"
    }

    private fun nextQuestion() {
        currentTest++
        if (currentTest < questions.size) {
            loadQuestion()
        } else {
            showResult()
        }
    }

    private fun showResult() {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("correctCount", correctLevel)
        startActivity(intent)
        finish()
    }
}
