using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Crud_Linq_To_Sql
{
    public partial class Form1 : Form
    {
        StudentDBDataContext db;
        public Form1()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void button4_Click(object sender, EventArgs e)
        {

        }

        private void INSERTbutton_Click(object sender, EventArgs e)
        {
            db = new StudentDBDataContext();
            student std = new student();



        }

        private void UPDATEbutton_Click(object sender, EventArgs e)
        {

        }
    }
}
