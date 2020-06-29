# Perfect Squares

class Solution:
    d = {}
    def numSquares(self, n: int) -> int:
        sum = 0
        counter = 0
        lst = self.getList(n)
        return self.helperNumSquares(n, lst)
    
    def helperNumSquares(self, n, lst):
        if self.d.get(n) is not None:
            return self.d.get(n)
        output = []
        counter = 1
        for i in lst:
            #print("Currently n: {} and i: {}".format(n, i))
            result = n - i
            if result == 0:
                self.d[n] = counter
                return counter
            elif result > 0:
                output.append(counter + self.helperNumSquares(result, lst))
        returnVal = min(output)
        self.d[n] = returnVal
        return returnVal
    
    
    # generate a list of all perfect squares less then or equal to n
    def getList(self, n):
        i = 1;
        lst = []
        while((i * i) <= n):
            lst.append(i*i)
            self.d[i*i] = 1
            i += 1
        return lst
