var page = require('webpage').create();
var system = require('system');
var args = system.args;

page.viewportSize = { width: 1600, height: 900 };

var url = args[1];
var componentId = args[2];

console.log(url);

page.open(url, function() {

    page.clipRect = page.evaluate(function() {
        var obj = document.getElementsByClassName('well')[0].getBoundingClientRect();
        if(componentId)
            obj = document.getElementById(componentId).getBoundingClientRect();
        return obj;
    });
  
  window.setTimeout(function () {
        page.render('/home/revenueAssuranceMetrics.png',{quality: '100'});
        phantom.exit();
    }, 10000);
});