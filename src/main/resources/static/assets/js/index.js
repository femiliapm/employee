var tableDataEmployee = {
  create: function () {
    if ($.fn.DataTable.isDataTable('#table-data-employee')) {
      $('#table-data-employee').DataTable().clear();
      $('#table-data-employee').DataTable().destroy();
    }

    $.ajax({
      url: '/test/employee',
      type: 'get',
      contentType: 'application/json',
      success: function (res, status, xhr) {
        if (xhr.status == 200 || xhr.status == 201) {
          console.log(res);
          $('#table-data-employee').DataTable({
            data: res,
            columns: [{
              title: 'Employee Code',
              data: 'employeeCode'
            }, {
              title: 'Employee Name',
              data: 'employeeName'
            }, {
              title: 'Status',
              data: 'status'
            }, {
              title: "Action",
              data: null,
              render: function (data, type, row) {
                console.log(data)
                console.log(data.employeeId);
                return (
                  '<div class="row"><div class="col-sm-6"><button class="btn btn-outline-warning" onclick=detailEmployee.create("' + data.employeeId + '")><svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-pencil-square" fill="currentColor" xmlns="http://www.w3.org/2000/svg"><path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456l-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z" /><path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z" /></svg></button></div></div>'

                  // '<div class="row"><div class="col-sm-6"><button class="btn btn-outline-warning" onclick=tableDataEmployee.setEditData("' + data.employeeId + '")><svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-pencil-square" fill="currentColor" xmlns="http://www.w3.org/2000/svg"><path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456l-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z" /><path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z" /></svg></button></div></div>'
                )
                // clipboard-data
                //   <div class="row">
                //   <div class="col-sm-6">
                //     <button class="btn btn-outline-warning" onclick={tableDataEmployee.setEditData(data.employeeId)}>
                //       <svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-pencil-square" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                //         <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456l-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z" />
                //         <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z" />
                //       </svg>
                //     </button>
                //   </div>
                // </div>
              }
            }]
          })
        }
      }, error: function (err) {
        console.log(err);
      }
    })
  },

  setEditData: function (employeeId) {
    $('#form-employee')[0].reset();

    $.ajax({
      url: '/test/employee/' + employeeId,
      method: 'get',
      contentType: 'application/json',
      dataType: 'json',
      success: function (res, status, xhr) {
        if (xhr.status == 200 || xhr.status == 201) {
          console.log(res[0]);
          $('#form-employee').fromJSON(JSON.stringify(res[0]));
          $('#modal-employee').modal('show')

        } else { }
      },
      error: function (err) {
        console.log(err);
      }
    });
  }
}

var detailEmployee = {
  create: function (employeeId) {
    if ($.fn.DataTable.isDataTable('#table-data-detail-organisation')) {
      $('#table-data-detail-organisation').DataTable().clear();
      $('#table-data-detail-organisation').DataTable().destroy();
    }
    if ($.fn.DataTable.isDataTable('#table-data-detail-position')) {
      $('#table-data-detail-position').DataTable().clear();
      $('#table-data-detail-position').DataTable().destroy();
    }

    $.ajax({
      url: '/test/detail/' + employeeId,
      method: 'get',
      contentType: 'application/json',
      dataType: 'json',
      success: function (res, status, xhr) {
        if (xhr.status == 200 || xhr.status == 201) {
          console.log(res[0].employeeCode);
          console.log(res);
          $('#modal-detail-employee').modal('show')

          $('#detail-employeeCode').val(res[0].employeeCode)
          $('#detail-employeeName').val(res[0].employeeName)

          $('#table-data-detail-organisation').DataTable({
            data: res,
            columns: [{
              title: 'Organisation Code',
              data: 'organisationCode'
            }, {
              title: 'Valid From',
              data: 'validFromOrganisation'
            }, {
              title: 'Valid To',
              data: 'validToOrganisation'
            }]
          })

          $('#table-data-detail-position').DataTable({
            data: res,
            columns: [{
              title: 'Position Code',
              data: 'positionCode'
            }, {
              title: 'Position Name',
              data: 'positionName'
            }, {
              title: 'Valid From',
              data: 'validFromPosition'
            }, {
              title: 'Valid To',
              data: 'validToPosition'
            }]
          })
        }
      },
      error: function (err) {
        console.log(err);
      }
    })
  }
}

var dataEmployee = {
  create: function (employeeId) {
    $.ajax({
      url: '/test/detail/' + employeeId,
      method: 'get',
      contentType: 'application/json',
      dataType: 'json',
      success: function (res, status, xhr) {
        if (xhr.status == 200 || xhr.status == 201) {
          console.log(res[0].employeeCode);
          console.log(res);
          $('#employeeCode').val(res[0].employeeCode)
          $('#employeeName').val(res[0].employeeName)
        }
      }
    })
  }
}

var tableDataOrganisation = {
  create: function (employeeId) {
    if ($.fn.DataTable.isDataTable('#table-data-organisation')) {
      $('#table-data-organisation').DataTable().clear();
      $('#table-data-organisation').DataTable().destroy();
    }

    $.ajax({
      url: '/test/detail/' + employeeId,
      type: 'get',
      contentType: 'application/json',
      success: function (res, status, xhr) {
        if (xhr.status == 200 || xhr.status == 201) {
          console.log(res);
          $('#table-data-organisation').DataTable({
            data: res,
            columns: [{
              title: 'Organisation Code',
              data: 'organisationCode'
            }, {
              title: 'Valid From',
              data: 'validFromOrganisation'
            }, {
              title: 'Valid To',
              data: 'validToOrganisation'
            }]
          })
        }
      }, error: function (err) {
        console.log(err);
      }
    })
  }
}

var tableDataPosition = {
  create: function (employeeId) {
    if ($.fn.DataTable.isDataTable('#table-data-position')) {
      $('#table-data-position').DataTable().clear();
      $('#table-data-position').DataTable().destroy();
    }

    $.ajax({
      url: '/test/detail/' + employeeId,
      type: 'get',
      contentType: 'application/json',
      success: function (res, status, xhr) {
        if (xhr.status == 200 || xhr.status == 201) {
          console.log(res);
          $('#table-data-position').DataTable({
            data: res,
            columns: [{
              title: 'Position Code',
              data: 'positionCode'
            }, {
              title: 'Position Name',
              data: 'positionName'
            }, {
              title: 'Valid From',
              data: 'validFromPosition'
            }, {
              title: 'Valid To',
              data: 'validToPosition'
            }]
          })
        }
      }, error: function (err) {
        console.log(err);
      }
    })
  }
}

var formOrganisation = {
  resetForm: function () {
    $('#form-organisation')[0].reset()
  },

  saveForm: function () {
    // if ($('#form-organisation').parsley().validate()) {
    var data = getJsonForm($('#form-organisation').serializeArray(), true);

    $.ajax({
      url: '/api/organisation/insert',
      type: 'post',
      contentType: 'application/json',
      dataType: 'json',
      data: JSON.stringify(data),
      success: function (res, status, xhr) {
        console.log(res);
      }
    })
    // }
  }
}