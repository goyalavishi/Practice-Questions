#include<iostream>
using namespace std;
#include<vector>

class Node{
    public:
    int row=0;
    int col=0;
    int value=0;
    Node* next=NULL;

    Node(int row,int col,int value,Node* next)
    {
        this->row=row;
        this->col=col;
        this->value=value;
        this->next=next;
    }
};

void createnewnode(int row,int col,int value,Node*& start)
{
    if(start==NULL)
    {
        start=new Node(row,col,value,NULL);
    }
    else if(start->next==NULL){
        Node* nn=new Node(row,col,value,NULL);
        start->next=nn;
    }
    else{
        Node* temp=start;
        while(temp->next!=NULL)
        {
            temp=temp->next;
        }
        Node *nn = new Node(row, col, value, NULL);
        temp->next = nn;
    }
}

void display(Node* start)
{
    Node* rp=start;
    Node *cp = start;
    Node *vp = start;

    cout<<" Row position: ";
    while(rp!=NULL)
    {
        cout<<rp->row<<" ";
        rp=rp->next;
    }
    cout<<endl;

    cout << " Column position: ";
    while (cp != NULL)
    {
        cout << cp->col << " ";
        cp = cp->next;
    }
    cout << endl;

    cout << " Value : ";
    while (vp != NULL)
    {
        cout << vp->value << " ";
        vp = vp->next;
    }
    cout << endl;
}

int main(int argc,char** argv)
{
    Node* start=NULL;
    vector<vector<int>> v{
        {0, 0, 3, 0, 4},
        {0, 0, 5, 7, 0},
        {0, 0, 0, 0, 0},
        {0, 2, 6, 0, 0}
    };

    for (int i = 0; i <v.size();i++)
    {
        for(int j=0;j<v[0].size();j++)
        {
            if(v[i][j]!=0)
            {
                createnewnode(i,j,v[i][j],start);
            }
        }
    }

    display(start);
}