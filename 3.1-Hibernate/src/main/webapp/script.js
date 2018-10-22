function checkDescription() {
    var result = true;
    var element = document.getElementById('description');
    if (element.value === '') {
        result = false;
        alert(element.title);
    }
    return result;
};

function loadItems() {
    $.ajax({
        type:"GET",
        url: "/ajax",
        complete: function (data, textStatus) {
            if (textStatus) {
                var result = "";
                var doneStaus;
                var checkStatus = document.getElementById("check").checked;
                var items = JSON.parse(data.responseText);
                if (!checkStatus) {
                    for (var i = 0; i < items.length; i++) {
                        if (items[i].done) {
                            doneStatus = "<td style='color: green'>&#10004</td>\n"
                        } else {
                            doneStatus = "<td style='color: red'>&#10008</td>\n"
                        }
                        result += createElement(items[i], doneStatus);
                    }
                } else {
                    for (var i = 0; i < items.length; i++) {
                        if (!items[i].done) {
                            doneStatus = "<td style='color: red'>&#10008</td>\n";
                            result += createElement(items[i], doneStatus);
                        }
                    }
                }
                var table = document.getElementById("tbody");
                table.innerHTML = result;
            }
        }
    });
};

function createElement(item, doneStatus) {
    return "<tr>" +
        "<td>" + item.id + "</td>\n" +
        "<td>" + item.desc + "</td>\n" +
        "<td>" + item.created + "</td>\n" +
        doneStatus + "</tr>";
}


function createItem() {
    $.ajax({
        type: "POST",
        url: "/ajax",
        data:
            JSON.stringify({desc: $('#description').val()}),
        success : function (data, textStatus) {
            if(textStatus) {
                loadItems();
            }
        }
    })
};

function addItem() {
    if (checkDescription()) {
        createItem();
    }
};

$(document).ready(function() {
    loadItems();
});