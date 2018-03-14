var page = require('webpage').create();
page.viewportSize = { width: 1600, height: 900 };

var args = phantom.args;
var url = args[2];
var componentId = args[3];

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