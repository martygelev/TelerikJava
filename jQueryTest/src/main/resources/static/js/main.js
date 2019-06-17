"use strict";
// function test() {
//     alert($("#btn").val())
// }

function addName() {
    const input = $("#txt");
    const myParagraph = $("#result");
    myParagraph.html(input.val());

}