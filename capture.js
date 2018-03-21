var page = require('webpage').create();
var system = require('system');
var args = system.args;

page.viewportSize = { width: 1600, height: 900 };

var url = args[1];
var componentId = args[2];

page.open(url, function() {
    page.clipRect = page.evaluate(function(id){
        var obj;
        if(id)
          obj = document.getElementById(id).getBoundingClientRect();
        else
          obj = document.getElementsByClassName('well')[0].getBoundingClientRect();
        return obj;
    },componentId);

  window.setTimeout(function () {
        page.render('snapshot/revenueAssuranceMetrics.png',{quality:'100'});
        console.log("success");
        phantom.exit();
    }, 10000);
});
