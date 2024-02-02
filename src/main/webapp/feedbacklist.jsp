<!DOCTYPE html>
<html>
  <head>
    <meta charset="ISO-8859-1" />
    <title>Candidate Evaluation Application - Home</title>

    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
      crossorigin="anonymous"
    />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css"
    />
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
      crossorigin="anonymous"
    ></script>
    <link href="resources/css/main.css" rel="stylesheet" />
  </head>

  <body>
    <nav class="navbar navbar-expand-lg navbar-color">
      <div class="container-fluid">
        <a class="navbar-brand" href="home.html">
          <img
            alt=""
            src="resources\images\logo\logo.png"
            style="width: 120px; margin: 0px 60px"
          />
        </a>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarNav"
          aria-controls="navbarNav"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
          <ul class="navbar-nav">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="home.html"
                >Home</a
              >
            </li>
            <li class="nav-item">
              <a class="nav-link" href="home.html">Candidate</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="feedbacklist.html">Feedback</a>
            </li>
            <li class="nav-item dropdown">
              <a
                class="nav-link dropdown-toggle"
                href="#"
                role="button"
                data-bs-toggle="dropdown"
                aria-expanded="false"
              >
                Reports
              </a>
              <ul class="dropdown-menu">
                <li>
                  <a class="dropdown-item" href="#">Selected Candidate</a>
                </li>
                <li>
                  <a class="dropdown-item" href="#">Not Selected Candidate</a>
                </li>
              </ul>
            </li>
          </ul>
        </div>
        <div class="d-flex">
          <div class="dropdown ft-color">
            <button
              class="btn btn-eviden dropdown-toggle"
              type="button"
              data-bs-toggle="dropdown"
              aria-expanded="false"
            ></button>
            <ul class="dropdown-menu">
              <li>
                <a class="dropdown-item" href="/cewebapp/ceapp/logout"
                  >Logout</a
                >
              </li>
            </ul>
          </div>
        </div>
      </div>
    </nav>
    <div class="container my-2">
      <form action="/cewebapp/ceapp/candidate/search">
        <div class="row my-3">
          <div class="col-10">
            <input
              type="search"
              name="candidateName"
              placeholder="Enter candidate name"
              class="form-control"
            />
          </div>
          <div class="col-2">
            <input type="submit" class="btn btn-eviden" />
          </div>
        </div>
      </form>
      <table class="table table-bordered table-striped m-2">
        <tr>
          <th>ID</th>
          <th>Evaluator Name</th>
          <th>Candidate Name</th>
          <th>Screening Level</th>
          <th>Status</th>
          <th>Comment</th>
        </tr>

        <tr>
          <td>1</td>
          <td>Praveen Naik</td>
          <td>Rajesh Sharma</td>
          <td>L1</td>
          <td>selected</td>
          <td>Good</td>
        </tr>

        <tr>
          <td>2</td>
          <td>Priya Sathe</td>
          <td>Rajesh Sharma</td>
          <td>L2</td>
          <td>selected</td>
          <td>Good</td>
        </tr>

        <tr>
          <td>3</td>
          <td>Jayesh More</td>
          <td>Rajesh Sharma</td>
          <td>L3</td>
          <td>selected</td>
          <td>Good</td>
        </tr>

        <tr>
          <td>4</td>
          <td>Praveen Naik</td>
          <td>Jay Patel</td>
          <td>L1</td>
          <td>not selected</td>
          <td>Need Improvment</td>
        </tr>

        <tr>
          <td>100</td>
          <td>Priya Sathe</td>
          <td>Mayur Shinde</td>
          <td>L1</td>
          <td>selected</td>
          <td>Nice</td>
        </tr>

        <tr>
          <td>101</td>
          <td>Praveen Naik</td>
          <td>Mayur Shinde</td>
          <td>L2</td>
          <td>selected</td>
          <td>Good</td>
        </tr>

        <tr>
          <td>102</td>
          <td>Jayesh More</td>
          <td>Kiran</td>
          <td>L1</td>
          <td>not selected</td>
          <td>Not Good in comm</td>
        </tr>

        <tr>
          <td>103</td>
          <td>Praveen Naik</td>
          <td>Shubham Surve</td>
          <td>L1</td>
          <td>not selected</td>
          <td>Week in Communication</td>
        </tr>

        <tr>
          <td>104</td>
          <td>Praveen Naik</td>
          <td>Shubham Surve</td>
          <td>L1</td>
          <td>not selected</td>
          <td>Week in Communication</td>
        </tr>

        <tr>
          <td>105</td>
          <td>Jayesh More</td>
          <td>Mayur Shinde</td>
          <td>L3</td>
          <td>not selected</td>
          <td>qwertyui</td>
        </tr>

        <tr>
          <td>106</td>
          <td>Priya Sathe</td>
          <td>Hitesh Yadav</td>
          <td>L1</td>
          <td>selected</td>
          <td>Good</td>
        </tr>

        <tr>
          <td>107</td>
          <td>Praveen Naik</td>
          <td>Hitesh Yadav</td>
          <td>L2</td>
          <td>selected</td>
          <td>Good</td>
        </tr>

        <tr>
          <td>108</td>
          <td>Praveen Naik</td>
          <td>Hitesh Yadav</td>
          <td>L3</td>
          <td>selected</td>
          <td>Good</td>
        </tr>
      </table>
    </div>
  </body>
</html>
