
sortTotalTime(1, 40960000, "merge");

/**
 * 计算排序总时间
 * @param times
 * @param length
 * @param sortAlgo
 * @returns {number}
 */
function sortTotalTime(times, length, sortAlgo) {
    let doubles = new Array();
    let total = 0;
    for(let time = 0;time < times; time++){
        for (let i = 0; i < length; i++) {
            doubles[i] = Math.random();
        }
        total += sort(doubles);
        for(let i = 0; i < length-1; i++){
            if (doubles[i] > doubles [i+1]){
                console.log(sortAlgo, "算法排序出错");
                break;
            }
        }
    }
    console.log(sortAlgo, "算法对" ,length, "个数字的double数组执行",times, "次排序, 执行耗时", total, "ms");
    return total;
}

// js实现归并排序
function sort(arr){
    let start = new Date().getTime();
    let tempArr = arr.slice();
    const arrLen = arr.length;
    mergesort(arr, tempArr, 0, arrLen-1);
    console.log(arr);
    let end = new Date().getTime();
    return end-start;
}

function mergesort(arr, tempArr, left, right){
    if(left>=right){
        return;
    }
    let mid = Math.floor((left+right)/2);
    mergesort(arr, tempArr, left, mid);
    mergesort(arr, tempArr, mid+1, right);
    merge(arr, tempArr, left, mid, right);
}

function merge(arr, tempArr, left, mid, right){
    for(let i = left; i <= right; i++){
        tempArr[i] = arr[i];
    }

    let i = left;
    let j = mid + 1;
    let k = left;

    while(i <=mid && j <=right){
        if(tempArr[i] < tempArr[j]){
            arr[k++] = tempArr[i++];
        }else{
            arr[k++] = tempArr[j++];
        }
    }

    while(i<=mid){
        arr[k++] = tempArr[i++];
    }

    while(j <= right){
        arr[k++] = tempArr[j++];
    }
}
