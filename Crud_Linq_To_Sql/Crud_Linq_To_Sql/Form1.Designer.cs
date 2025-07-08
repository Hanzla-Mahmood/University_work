namespace Crud_Linq_To_Sql
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.NAMEtextBox = new System.Windows.Forms.TextBox();
            this.GENDERtextBox = new System.Windows.Forms.TextBox();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.AGEtextBox = new System.Windows.Forms.TextBox();
            this.label5 = new System.Windows.Forms.Label();
            this.CLASStextBox = new System.Windows.Forms.TextBox();
            this.INSERTbutton = new System.Windows.Forms.Button();
            this.UPDATEbutton = new System.Windows.Forms.Button();
            this.DELETEbutton = new System.Windows.Forms.Button();
            this.CLEARbutton = new System.Windows.Forms.Button();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            this.SuspendLayout();
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Cooper Black", 20F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.Red;
            this.label1.Location = new System.Drawing.Point(138, 9);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(427, 46);
            this.label1.TabIndex = 0;
            this.label1.Text = "STUDENTS DETAIL";
            this.label1.Click += new System.EventHandler(this.label1_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 11F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.Location = new System.Drawing.Point(163, 75);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(80, 26);
            this.label2.TabIndex = 1;
            this.label2.Text = "NAME";
            this.label2.Click += new System.EventHandler(this.label2_Click);
            // 
            // NAMEtextBox
            // 
            this.NAMEtextBox.Location = new System.Drawing.Point(326, 75);
            this.NAMEtextBox.Name = "NAMEtextBox";
            this.NAMEtextBox.Size = new System.Drawing.Size(239, 26);
            this.NAMEtextBox.TabIndex = 0;
            this.NAMEtextBox.TextChanged += new System.EventHandler(this.textBox1_TextChanged);
            // 
            // GENDERtextBox
            // 
            this.GENDERtextBox.Location = new System.Drawing.Point(326, 119);
            this.GENDERtextBox.Name = "GENDERtextBox";
            this.GENDERtextBox.Size = new System.Drawing.Size(239, 26);
            this.GENDERtextBox.TabIndex = 1;
            this.GENDERtextBox.TextChanged += new System.EventHandler(this.textBox1_TextChanged);
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Font = new System.Drawing.Font("Microsoft Sans Serif", 11F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label3.Location = new System.Drawing.Point(163, 117);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(113, 26);
            this.label3.TabIndex = 1;
            this.label3.Text = "GENDER";
            this.label3.Click += new System.EventHandler(this.label2_Click);
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Font = new System.Drawing.Font("Microsoft Sans Serif", 11F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label4.Location = new System.Drawing.Point(163, 159);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(62, 26);
            this.label4.TabIndex = 1;
            this.label4.Text = "AGE";
            this.label4.Click += new System.EventHandler(this.label2_Click);
            // 
            // AGEtextBox
            // 
            this.AGEtextBox.Location = new System.Drawing.Point(326, 161);
            this.AGEtextBox.Name = "AGEtextBox";
            this.AGEtextBox.Size = new System.Drawing.Size(239, 26);
            this.AGEtextBox.TabIndex = 3;
            this.AGEtextBox.TextChanged += new System.EventHandler(this.textBox1_TextChanged);
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Font = new System.Drawing.Font("Microsoft Sans Serif", 11F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label5.Location = new System.Drawing.Point(163, 203);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(90, 26);
            this.label5.TabIndex = 1;
            this.label5.Text = "CLASS";
            this.label5.Click += new System.EventHandler(this.label2_Click);
            // 
            // CLASStextBox
            // 
            this.CLASStextBox.Location = new System.Drawing.Point(326, 203);
            this.CLASStextBox.Name = "CLASStextBox";
            this.CLASStextBox.Size = new System.Drawing.Size(239, 26);
            this.CLASStextBox.TabIndex = 4;
            this.CLASStextBox.TextChanged += new System.EventHandler(this.textBox1_TextChanged);
            // 
            // INSERTbutton
            // 
            this.INSERTbutton.FlatStyle = System.Windows.Forms.FlatStyle.System;
            this.INSERTbutton.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.INSERTbutton.Location = new System.Drawing.Point(101, 260);
            this.INSERTbutton.Name = "INSERTbutton";
            this.INSERTbutton.Size = new System.Drawing.Size(102, 39);
            this.INSERTbutton.TabIndex = 5;
            this.INSERTbutton.Text = "INSERT";
            this.INSERTbutton.UseVisualStyleBackColor = true;
            this.INSERTbutton.Click += new System.EventHandler(this.INSERTbutton_Click);
            // 
            // UPDATEbutton
            // 
            this.UPDATEbutton.FlatStyle = System.Windows.Forms.FlatStyle.System;
            this.UPDATEbutton.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.UPDATEbutton.Location = new System.Drawing.Point(232, 260);
            this.UPDATEbutton.Name = "UPDATEbutton";
            this.UPDATEbutton.Size = new System.Drawing.Size(102, 39);
            this.UPDATEbutton.TabIndex = 6;
            this.UPDATEbutton.Text = "UPDATE";
            this.UPDATEbutton.UseVisualStyleBackColor = true;
            this.UPDATEbutton.Click += new System.EventHandler(this.UPDATEbutton_Click);
            // 
            // DELETEbutton
            // 
            this.DELETEbutton.FlatStyle = System.Windows.Forms.FlatStyle.System;
            this.DELETEbutton.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.DELETEbutton.Location = new System.Drawing.Point(355, 260);
            this.DELETEbutton.Name = "DELETEbutton";
            this.DELETEbutton.Size = new System.Drawing.Size(102, 39);
            this.DELETEbutton.TabIndex = 7;
            this.DELETEbutton.Text = "DELETE";
            this.DELETEbutton.UseVisualStyleBackColor = true;
            // 
            // CLEARbutton
            // 
            this.CLEARbutton.FlatStyle = System.Windows.Forms.FlatStyle.System;
            this.CLEARbutton.Font = new System.Drawing.Font("Microsoft Sans Serif", 9F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.CLEARbutton.Location = new System.Drawing.Point(487, 260);
            this.CLEARbutton.Name = "CLEARbutton";
            this.CLEARbutton.Size = new System.Drawing.Size(102, 39);
            this.CLEARbutton.TabIndex = 8;
            this.CLEARbutton.Text = "CLEAR";
            this.CLEARbutton.UseVisualStyleBackColor = true;
            this.CLEARbutton.Click += new System.EventHandler(this.button4_Click);
            // 
            // dataGridView1
            // 
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Location = new System.Drawing.Point(42, 305);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.RowHeadersWidth = 62;
            this.dataGridView1.RowTemplate.Height = 28;
            this.dataGridView1.Size = new System.Drawing.Size(673, 194);
            this.dataGridView1.TabIndex = 4;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(9F, 20F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 504);
            this.Controls.Add(this.dataGridView1);
            this.Controls.Add(this.CLEARbutton);
            this.Controls.Add(this.DELETEbutton);
            this.Controls.Add(this.UPDATEbutton);
            this.Controls.Add(this.INSERTbutton);
            this.Controls.Add(this.CLASStextBox);
            this.Controls.Add(this.AGEtextBox);
            this.Controls.Add(this.GENDERtextBox);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.NAMEtextBox);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Name = "Form1";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox NAMEtextBox;
        private System.Windows.Forms.TextBox GENDERtextBox;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox AGEtextBox;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox CLASStextBox;
        private System.Windows.Forms.Button INSERTbutton;
        private System.Windows.Forms.Button UPDATEbutton;
        private System.Windows.Forms.Button DELETEbutton;
        private System.Windows.Forms.Button CLEARbutton;
        private System.Windows.Forms.DataGridView dataGridView1;
    }
}

