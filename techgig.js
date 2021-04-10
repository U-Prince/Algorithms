process.stdin.resume();
process.stdin.setEncoding('ascii');

var input_stdin = "";
var input_stdin_array = "";
var input_currentline = 0;

process.stdin.on('data', function (data) {
    input_stdin += data;
});

function sortNumber(a,b) {
    return a - b;
}

process.on('exit', function () {
    input_stdin_array = input_stdin.split("\n");
	
	let T = input_stdin_array[0];
    for(let i=0;i<T;i++) {
        let N = input_stdin_array[3*i+1];
        let V = input_stdin_array[3*i+2].trim().split(' ').map(Number);
        let P = input_stdin_array[3*i+3].trim().split(' ').map(Number);
        V.sort(sortNumber);
        P.sort(sortNumber);
        console.log(P,V);
        let flag=0;
        for(let j=0;j<N;j++) {
            if(P[j] <= V[j]) {
                flag=1;
                break;
            }
        }
        if(flag==1) {
            process.stdout.write("LOSE\n");
        }else {
            process.stdout.write("WIN\n");
        }
    }
     
});
